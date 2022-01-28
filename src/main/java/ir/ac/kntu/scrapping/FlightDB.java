package ir.ac.kntu.scrapping;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class FlightDB {

    public static final DBObject toDBObject(Flight flight){
        return new BasicDBObject("id", flight.getFlightId()).append("departure",flight.getDepartFrom())
                .append("destination",flight.getDestination());
    }

}
