package ir.ac.kntu.scrapping;

import com.mongodb.*;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import ir.ac.kntu.Data.Query;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args) throws InterruptedException {
//        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
//        randomDataGenerator.generate(100);
        MongoCollection<Document> collection = MongoDBSetUp.getInstance().getDatabase("FlightDataBase").getCollection("flights");
        Query query = new Query();
        Date date = new Date(new Date().getYear(),Calendar.FEBRUARY,7,0,0);
        Document query11 = new Document("id","563");
        AggregateIterable<Document> x = collection.aggregate(query.firstQuery(date));
        List<Document> result = new ArrayList<Document>();
        x.forEach((Block<? super Document>) result::add);
        for (Document doc:
             result) {
            System.out.println(doc.toJson().toString());
        }

//                .forEach((Block<? super Document>)
//                        doc -> System.out.println(doc.toJson()));
//        int cnt = 0;
//        Iter.forEach((Block<? super Document>)
//                doc -> System.out.println(doc.toJson()));
    }

}

