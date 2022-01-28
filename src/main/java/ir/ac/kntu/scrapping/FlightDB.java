package ir.ac.kntu.scrapping;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import ir.ac.kntu.Data.Flight;

public class FlightDB {

    public static final DBObject toDBObject(Flight flight){
        return new BasicDBObject("id", flight.getFlightId()).append("departure",flight.getDepartFrom())
                .append("destination",flight.getDestination());
    }

}

//.append("flightDate",flight.getFlightDate())
//        .append("airline",flight.getAirline()).append("arrivalTime",flight.getArrivalDate())
//        .append("arrivalGate",flight.getArrivalGate()).append("departureGate", flight.getDepartureGate())
//        .append("flightDuration",flight.getFlightDuration()