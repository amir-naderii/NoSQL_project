package ir.ac.kntu.scrapping;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import ir.ac.kntu.Data.Flight;
import ir.ac.kntu.Data.Query;
import ir.ac.kntu.Data.RandomDataGenerator;
import org.bson.Document;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args) throws InterruptedException {
//        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
//        randomDataGenerator.generate(100);
        MongoCollection collection = MongoDBSetUp.getInstance().getDatabase("FlightDataBase").getCollection("flights");
        Query query = new Query();
        Date date = new Date(new Date().getYear(),Calendar.FEBRUARY,7,0,0);
        Document query11 = new Document("flightId","563");
        collection.updateOne(query11,query.eleventhQuery(310));
        int cnt = 0;
//        Iter.forEach((Block<? super Document>)
//                doc -> System.out.println(doc.toJson()));
//        System.out.println(cursor.size());
//        while(cursor.size() > cnt){
//            System.out.println("boozh boozh");
//            System.out.println(cursor.next().get("flightId").toString());
//            cnt++;
        }

    }

