package ir.ac.kntu.scrapping;


import ir.ac.kntu.Data.Flight;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.*;

public class Scraper {

    public static void main(String[] args) throws IOException {
        getAllFlights();

    }

    public static List<Flight> getAllFlights() throws IOException {
        List<Flight> flights = new ArrayList<Flight>();
        final String emirates = "";

        final Document document = Jsoup.connect(emirates).get();
        System.out.println(document.body());
        for( Element element : document.select(" tr")){
            System.out.println(element.getAllElements().text());
//            String departFrom = element.select("td").text();
//            System.out.println(departFrom);
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
