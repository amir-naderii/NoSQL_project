package ir.ac.kntu.scrapping;

import com.mongodb.*;
import ir.ac.kntu.Data.Flight;
import ir.ac.kntu.Data.Query;
import ir.ac.kntu.Data.RandomDataGenerator;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args) throws InterruptedException {
//        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
//        randomDataGenerator.generate(100);
        DBCollection collection = MongoDBSetUp.getInstance().getDB("FlightDataBase").getCollection("flights");
        Query query = new Query();
        DBCursor cursor = query.firstQuery(collection,new Date(new Date().getYear(), Calendar.FEBRUARY,3,0,0));
        int cnt = 0;
        System.out.println(cursor.size());
        while(cursor.size() > cnt){
            System.out.println("boozh boozh");
            System.out.println(cursor.next().get("flightId").toString());
            cnt++;
        }

    }
}
