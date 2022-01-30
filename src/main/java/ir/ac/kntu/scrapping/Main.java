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
        Date date = new Date(new Date().getYear(),Calendar.FEBRUARY,1,0,0);
        Date nextDate = new Date(new Date().getYear(),Calendar.FEBRUARY,7,0,0);

        Document query11 = new Document("id","563");
        //List<AggregateIterable> x = query.pagingQuery(collection, 20);
        AggregateIterable<Document> iter = collection.aggregate(query.eighthQuery(date,nextDate,"Tehran", "Istanbul", 252, 0, 0));
        //AggregateIterable<Document> iter = collection.aggregate(query.thirdQuery("Isfahan", "Doha"));
        iter.forEach((Block<? super Document>)
                    doc -> System.out.println(doc.toJson()));

//        List<Document> result = new ArrayList<Document>();
//        y.forEach((Block<? super Document>) result::add);
//        List<AggregateIterable> x = query.pagingQuery((MongoCollection<Document>) result, 20);
//        for (AggregateIterable iter : x) {
//            iter.forEach((Block<? super Document>)
//                    doc -> System.out.println(doc.toJson()));
//            System.out.println();
//        }

//        for (Document doc:
//             result) {
//            System.out.println(doc.toJson().toString());
//        }

//        int cnt = 0;
//        Iter.forEach((Block<? super Document>)
//                doc -> System.out.println(doc.toJson()));
    }

}

