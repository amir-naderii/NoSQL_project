package ir.ac.kntu.scrapping;

import com.mongodb.*;
import com.mongodb.client.*;


public class main {

    public static void main(String[] args) throws InterruptedException {
        DB db = MongoDBSetUp.getInstance().getDB("local");
        DBCollection collection = db.getCollection("startup_log");
        DBObject query = new BasicDBObject("_id", "LAPTOP-V8A7BAA5-1643204769310");
        DBCursor cursor = collection.find(query);
        System.out.println((String)cursor.one().get("hostname"));







    }
}
