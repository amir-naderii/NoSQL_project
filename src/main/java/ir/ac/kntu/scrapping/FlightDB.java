package ir.ac.kntu.scrapping;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import ir.ac.kntu.Data.Flight;

public class FlightDB {

    public static final DBObject toDBObject(Flight flight){
        return new BasicDBObject("flightId", flight.getFlightId())
                .append("departure", new BasicDBObject("country",flight.getDepartFrom().getCountry())
                    .append("city",flight.getDepartFrom().getCity())
                    .append("airport",flight.getDepartFrom().getAirport()))
                .append("destination",new BasicDBObject("country",flight.getDestination().getCountry())
                    .append("city",flight.getDestination().getCity())
                    .append("airport",flight.getDestination().getAirport()))
                .append("flightDate",flight.getFlightDate())
                .append("airline",flight.getAirline()).append("arrivalDate",flight.getArrivalDate())
                .append("flightType",flight.getFlightType()).append("capacity",flight.getCapacity())
                .append("cost",flight.getCost());
    }

}

//.append("flightDate",flight.getFlightDate())
//        .append("airline",flight.getAirline()).append("arrivalTime",flight.getArrivalDate())
//        .append("arrivalGate",flight.getArrivalGate()).append("departureGate", flight.getDepartureGate())
//        .append("flightDuration",flight.getFlightDuration()

//
