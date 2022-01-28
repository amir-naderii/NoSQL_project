package ir.ac.kntu.scrapping;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;


public class main {

    public static void main(String[] args) throws InterruptedException {
        DB db = MongoDBSetUp.getInstance().getDB("Flight DataBase");


    }
}
