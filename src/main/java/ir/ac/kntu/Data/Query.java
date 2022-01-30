package ir.ac.kntu.Data;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.*;
import org.bson.BSON;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.io.File;
import java.util.*;

public class Query {
    private Scanner in;

    public Query() {
        in = new Scanner(System.in);
    }

    public Document firstQuery(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        Date nextDate = c.getTime();
        return  new Document("$and", Arrays.asList(
                new Document("flightDate", new Document("$gte", date)),
                new Document("flightDate", new Document("$lt", nextDate))));

    }



    public Document secondQuery(int priceFrom, int priceTo) {
        return new Document("$and", Arrays.asList(
                new Document("cost", new Document("$gte", priceFrom)),
                new Document("cost", new Document("$lt", priceTo))));
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

//
    public Document fifthQuery(String flightType, Date date, int priceFrom,
                                int priceTo, String departure, String destination,String avrOrMax){
        Document fifthQuery = null;
        if(date != null) {
            fifthQuery = new Document("$and", Arrays.asList(
                    new Document("flightType", flightType),
                    firstQuery(date)));
        }else if(priceFrom != 0 && priceTo != 0){
            fifthQuery = new Document("$and", Arrays.asList(
                    new Document("flightType", flightType),
                    secondQuery( priceFrom, priceTo)));}
        else if(avrOrMax.equals("avr")){
            fifthQuery = new Document("$and", Arrays.asList(
                    new Document("flightType", flightType),
                    forthQuery(departure, destination)));
        }else if(avrOrMax.equals("max")){
            fifthQuery = new BasicDBObject("$and", Arrays.asList(
                    new Document("flightType", flightType),
                    thirdQuery(departure, destination)));
        }

        return fifthQuery;
    }

    public FindIterable sixthQuery(int priceFrom,
                               int priceTo, String departure, String destination){
        Document sixthQuery = new Document("$and", Arrays.asList(
                new Document("departure.city",departure),
                new Document("destination.city",destination),
                new Document("cost", new Document("$gte", priceFrom)),
                new Document("cost", new Document("$lt", priceTo))));
    }

    public Document seventhQuery(String departure, String destination, int capacity){
        return new Document("$and",Arrays.asList(
                new Document("departure.city", departure),
                new Document("destination.city", destination),
                new Document("capacity",capacity)));
    }

    public Document eighthQuery(Date dateFrom, Date dateTo, String departure, String destination, int capacity,
                                int priceFrom, int priceTo){
        Document eighthQuery = null;
        if(capacity == 0){
            eighthQuery = new Document("$and",Arrays.asList(
                    new Document("flightDate", new Document("$gte", dateFrom)),
                    new Document("flightDate", new Document("$lt", dateTo)),
                    sixthQuery(priceFrom,priceTo,departure,destination)
            ));
        }else if(priceTo == 0){
            eighthQuery = new Document("$and",Arrays.asList(
                    new Document("flightDate", new Document("$gte", dateFrom)),
                    new Document("flightDate", new Document("$lt", dateTo)),
                    seventhQuery(departure,destination,capacity)));
        }
        return eighthQuery;
    }

    public Document ninthQuery(String departure, String destination, Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        Date nextDate = c.getTime();
        return new Document("$and",Arrays.asList(
                new Document("departure.city", departure),
                new Document("destination.city", destination),
                new Document("flightDate", new Document("$gte", date)),
                new Document("flightDate", new Document("$lt", nextDate))));
    }// add this to the end of find in helper function .projection(Projections.include("airline"))

    public Document tenthQuery(Date date, String airline){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        Date nextDate = c.getTime();
        return new Document("$and",Arrays.asList(
                new Document("airline",airline),
                new Document("flightDate", new Document("$gte", date)),
                new Document("flightDate", new Document("$lt", nextDate))));
    }// this query is for deletion

    public Bson updateCapacity(int newCapacity){
        Bson update = Updates.set("capacity",newCapacity);
        return update;
    }

    public Document eleventhQuery(String flightId){
        return new Document("flightId",flightId);
    }
    // collection.updateOne(query.eleventhQuery(flightId,query.updateCapacity(newCapacity);

    public Document twelfthQuery(String airline, Date date, String departure, String destination){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        Date nextDate = c.getTime();
        return new Document("$and",Arrays.asList(
                new Document("departure.city", departure),
                new Document("destination.city", destination),
                new Document("flightDate", new Document("$gte", date)),
                new Document("flightDate", new Document("$lt", nextDate))
        ));
    }
    //collection.updateOne(query.twelfthQuery(flightId,query.updateCapacity(newCapacity);

    public Document thirteenthQuery(String departureCon, String destinationCon, Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        Date nextDate = c.getTime();
        return new Document("$and",Arrays.asList(
                new Document("departure.country", departureCon),
                new Document("destination.country", destinationCon),
                new Document("flightDate", new Document("$gte", date)),
                new Document("flightDate", new Document("$lt", nextDate))));
    }
    // .projection(Projections.include("departure.airport","destination.airport))

    public FindIterable sortQuery(MongoCollection collection,Document doc, boolean ascOrDesc, boolean dateOrCost){
        FindIterable iter = null;
        if(ascOrDesc && dateOrCost) {
            iter = collection.find(doc).sort(Sorts.ascending("flightDate"));
        }
        else if(ascOrDesc){
            iter = collection.find(doc).sort(Sorts.ascending("cost"));
        }else if(dateOrCost){
            iter = collection.find(doc).sort(Sorts.descending("flightDate"));
        }else{
            iter = collection.find(doc).sort(Sorts.descending("cost"));
        }
        return iter;
    }
}

