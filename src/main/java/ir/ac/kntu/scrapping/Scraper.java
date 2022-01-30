package ir.ac.kntu.scrapping;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import ir.ac.kntu.Data.Address;
import ir.ac.kntu.Data.Flight;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Date;

public class Scraper {

    public static void main(String[] args) throws IOException {
        getAllFlights();

    }

    public static void getAllFlights() throws IOException {
        final String emirates = "https://sacramento.aero/smf/flight-and-travel/flight-status";

        final Document document = Jsoup.connect(emirates).get();

        for( Element element : document.select("table.table-flight.table-arrival.table-flight-sort tr")){
            String depart = element.select(".tooltip").text();
            Address departFrom = new Address(null, null, depart);
            String arrivalTime = element.select(".time").text();
            int hour = 0;
            int minute = 0;
            if(arrivalTime.matches(".*AM$")){
                hour = Integer.parseInt(arrivalTime.substring(0, arrivalTime.length()-5));
                minute = Integer.parseInt(arrivalTime.substring(3, arrivalTime.length()-2));
            }else if(arrivalTime.matches(".*PM$")){
                hour = Integer.parseInt(arrivalTime.substring(0, arrivalTime.length()-5))+12;
                minute = Integer.parseInt(arrivalTime.substring(3, arrivalTime.length()-2));
            }else {
                continue;
            }
            Date now = new Date();
            Date arrivalDate = new Date(now.getYear(),now.getMonth(),now.getDate(),hour, minute);
            String flightId = element.select(".first").text();
            String arrivalGate = element.select(".last").text();

            Flight f = new Flight(flightId, departFrom, arrivalDate, arrivalGate, now);
            DBObject flight = FlightDB.toRDBObject(f);
            DB db = MongoDBSetUp.getInstance().getDB("FlightDataBase");
            DBCollection collection = db.getCollection("flights");
            collection.insert(flight);
        }
    }
}
