package ir.ac.kntu.Data;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.DBCollectionCountOptions;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.io.File;
import java.util.*;

public class Query {
    private Scanner in;

    public Query() {
        in = new Scanner(System.in);
    }

    public FindIterable firstQuery(MongoCollection collection, Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        Date nextDate = c.getTime();
        System.out.println(date.toString());
        System.out.println(nextDate.toString());
        Document firstQuery = new Document("$and", Arrays.asList(
                new Document("flightDate", new Document("$gte", date)),
                new Document("flightDate", new Document("$lt", nextDate))));
        return collection.find(firstQuery);

    }

    public FindIterable secondQuery(MongoCollection collection, int priceFrom, int priceTo) {
        Document secondQuery = new Document("$and", Arrays.asList(
                new Document("cost", new Document("$gte", priceFrom)),
                new Document("cost", new Document("$lt", priceTo))));
        return collection.find(secondQuery);
    }

//    public DBCursor thirdQuery(MongoCollection collection, String departure, String destination) {
////        Bson match = Aggregates.match(
////                Filters.eq("", countryId)
////        BasicDBObject thirdQuery = new BasicDBObject( "$group",new BasicDBObject("$and", Arrays.asList(
////                new BasicDBObject("departure.city", departure),
////                new BasicDBObject("destination.city", destination))));
//        return collection.find(thirdQuery);
//    }

//    public DBCursor forthQuery(DBCollection collection,)
//    }


    public FindIterable fifthQuery(MongoCollection collection, String flightType, Date date, int priceFrom,
                                int priceTo, String departure, String destination,String avrOrMax){
        Document fifthQuery = null;
        if(date != null) {
            fifthQuery = new Document("$and", Arrays.asList(
                    new Document("flightType", flightType),
                    firstQuery(collection, date).));
        }else if(priceFrom != 0 && priceTo != 0){
            fifthQuery = new Document("$and", Arrays.asList(
                    new Document("flightType", flightType),
                    secondQuery(collection, priceFrom, priceTo).getQuery()));}
//        else if(avrOrMax.equals("avr")){
//            fifthQuery = new BasicDBObject("$and", Arrays.asList(
//                    new BasicDBObject("flightType", flightType),
//                    forthQuery(collection, departure, destination).getQuery()));
//        }else if(avrOrMax.equals("max")){
//            fifthQuery = new BasicDBObject("$and", Arrays.asList(
//                    new BasicDBObject("flightType", flightType),
//                    thirdQuery(collection, departure, destination).getQuery()));
//        }

        return collection.find(fifthQuery);
    }

    public DBCursor sixthQuery(MongoCollection collection, int priceFrom,
                               int priceTo, String departure, String destination){
        Document sixthQuery = new BasicDBObject("$and")
    }
}