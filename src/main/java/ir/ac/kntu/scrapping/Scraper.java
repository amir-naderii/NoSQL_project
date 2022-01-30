package ir.ac.kntu.scrapping;


import ir.ac.kntu.Data.Flight;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Scraper {

    public static void main(String[] args) throws IOException {
        getAllFlights();

    }

    public static List<Flight> getAllFlights() throws IOException {
        List<Flight> flights = new ArrayList<Flight>();
        final String emirates = "https://sacramento.aero/smf/flight-and-travel/flight-status";

        final Document document = Jsoup.connect(emirates).get();

        for( Element element : document.select("table.table-flight.table-arrival.table-flight-sort tr")){
            String departFrom = element.select(".tooltip").text();
            String arrivalTime = element.select(".time").text();
            String flightNumber = element.select(".first").text();
            String arrivalGate = element.select(".last").text();

//            String flightId = element.select("td").get(3).text();
//            String arrivalTime = element.select("td").get(1).text();
//            String Airline = element.select("td").get(2).text();
//            String arrivalGate = element.select("td").get(4).text();
//            Flight flight = new Flight();
//            flight.setFlightId(flightId);
//            flight.setDepartFrom(departFrom);
//            flight.setArrivalTime(arrivalTime);
//            flight.setAirline(Airline);
//            flight.setArrivalGate(arrivalGate);
//            flights.add(flight);
        }
         return flights;
    }
}
