package ir.ac.kntu.scrapping;

import com.mongodb.*;
import ir.ac.kntu.Data.Flight;


public class Main {

    public static void main(String[] args) throws InterruptedException {

          DB db = MongoDBSetUp.getInstance().getDB("FlightDataBase");
          DBObject flight = FlightDB.toDBObject(new Flight("Ia","Tehran","Istanbul"));
          DBCollection collection = db.getCollection("flights");
          collection.insert(flight);








    }
}
