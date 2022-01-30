package ir.ac.kntu;

import com.mongodb.client.MongoCollection;
import ir.ac.kntu.Data.Query;
import ir.ac.kntu.scrapping.MongoDBSetUp;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        MongoCollection<Document> collection = MongoDBSetUp.getInstance().getDatabase("FlightDataBase").getCollection("flights");
        Query query = new Query();
        Menu menu = new Menu(collection, query);
        menu.printMenu();
    }
}
