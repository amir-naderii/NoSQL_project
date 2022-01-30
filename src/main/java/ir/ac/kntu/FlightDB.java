package ir.ac.kntu;

import com.mongodb.client.MongoCollection;
import ir.ac.kntu.Data.Query;
import org.bson.Document;

import java.util.HashMap;

public class FlightDB {
    private HashMap<Integer, Document> queries;
    private MongoCollection collection;

    public FlightDB(MongoCollection collection) {
        this.collection = collection;
        queries = new HashMap<>();
    }
}
