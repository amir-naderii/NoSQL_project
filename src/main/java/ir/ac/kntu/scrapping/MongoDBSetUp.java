package ir.ac.kntu.scrapping;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDBSetUp {
    private static MongoDBSetUp single_instance = null;

    public MongoClient mongoClient;

    public MongoDBSetUp(){
        mongoClient = new MongoClient("local host",27017);
    }

    public static MongoClient getInstance(){
        if (single_instance == null){
            single_instance = new MongoDBSetUp();
        }
        return single_instance.mongoClient;
    }
}
