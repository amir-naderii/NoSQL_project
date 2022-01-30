package ir.ac.kntu.Data;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.print.Doc;
import java.util.*;

public class Query {

    public List<Document> firstQuery(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        Date nextDate = c.getTime();
        return Arrays.asList(new Document("$match", new Document("$and", Arrays.asList(
                new Document("flightDate", new Document("$gte", date))
                , new Document("flightDate", new Document("$lt", nextDate)))))
                , new Document("$project", new Document("_id", 0))
        );

    }

    public List<Document> secondQuery(int priceFrom, int priceTo) {
        return Arrays.asList(new Document("$match", new Document("$and", Arrays.asList(
                new Document("cost", new Document("$gte", priceFrom)),
                new Document("cost", new Document("$lt", priceTo)))))
                , new Document("$project", new Document("_id", 0))
        );
    }

    public List<Document> thirdQuery(String departure, String destination) {
        return Arrays.asList(
                new Document("$match", new Document("$and", Arrays.asList(new Document("destination.city",destination)
                        ,new Document("departure.city",departure))))
                , new Document("$group",new Document("_id", null)
                        .append("min", new Document("$min", "$cost"))
                        .append("max", new Document("$max", "$cost"))),
                new Document("$project", new Document("_id", 0))
        );
    }

    public List<Document> forthQuery(String departure, String destination) {
        return Arrays.asList(
                new Document("$match", new Document("$and", Arrays.asList(
                        new Document("destination.city",destination)
                        ,new Document("departure.city",departure)))),
                new Document("$group",new Document("_id", null)
                        .append("sum", new Document("$sum", "$cost"))
                        .append("avg", new Document("$avg", "$cost"))),
                new Document("$project", new Document("_id", 0)
                ));
    }

    public List<Document> fifthQuery(String flightType, Date date, int priceFrom,
                                int priceTo, String departure, String destination,String avrOrMax){
        List<Document> fifthQuery = null;
        if(date != null) {
            fifthQuery = firstQuery(date);
        }else if(priceFrom != 0 && priceTo != 0) {
            fifthQuery = secondQuery(priceFrom, priceTo);
        }else if(departure!= null && destination != null && avrOrMax.equals("max")){
            fifthQuery = thirdQuery(departure, destination);
        }else if(departure!= null && destination != null && avrOrMax.equals("avr")){
            fifthQuery = forthQuery(departure, destination);
        }
        ArrayList<Document> docs = new ArrayList<>(fifthQuery);
        docs.add(0,new Document("$match", new Document("flightType", flightType)));
        return docs;
    }

    public List<Document> sixthQuery(int priceFrom,
                               int priceTo, String departure, String destination){
        return Arrays.asList(new Document("$match", new Document("$and", Arrays.asList(
                new Document("destination.city",destination)
                , new Document("departure.city",departure)
                , new Document("cost", new Document("$gte", priceFrom))
                , new Document("cost", new Document("$lt", priceTo)))))
                , new Document("$group", new Document("_id", null)
                        .append("min", new Document("$min", "$cost")))
                ,new Document("$project", new Document("_id", 0))
        );
    }

    public List<Document> seventhQuery(String departure, String destination, int capacity){
        return Arrays.asList(new Document("$match", new Document("$and",Arrays.asList(
                new Document("departure.city", departure),
                new Document("destination.city", destination),
                new Document("capacity",capacity))))
                , new Document("$project", new Document("_id", 0))
        );
    }

    public List<Document> eighthQuery(Date dateFrom, Date dateTo, String departure,
                                      String destination, int capacity, int priceFrom, int priceTo){
        ArrayList<Document> eighthQuery = null;
        if(capacity == 0){
            eighthQuery = new ArrayList<>(
                    sixthQuery(priceFrom, priceTo, departure, destination));
            eighthQuery.add(0, new Document("$match", new Document("$and", Arrays.asList(
                    new Document("flightDate", new Document("$gte", dateFrom)),
                    new Document("flightDate", new Document("$lt", dateTo))))));
        }else if(priceTo == 0){
            eighthQuery = new ArrayList<>(seventhQuery(departure, destination, capacity));
            eighthQuery.add(0, new Document("$match", new Document("$and", Arrays.asList(
                    new Document("flightDate", new Document("$gte", dateFrom)),
                    new Document("flightDate", new Document("$lt", dateTo))))));
        }
        return eighthQuery;
    }

    public List<Document> ninthQuery(String departure, String destination, Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        Date nextDate = c.getTime();
        return Arrays.asList(new Document("$match", new Document("$and",Arrays.asList(
                new Document("departure.city", departure),
                new Document("destination.city", destination),
                new Document("flightDate", new Document("$gte", date)),
                new Document("flightDate", new Document("$lt", nextDate)))))
                , new Document("$project", new Document("_id", 0))
        );
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
        return  new Document("$and",Arrays.asList(
                new Document("departure.city", departure),
                new Document("destination.city", destination),
                new Document("flightDate", new Document("$gte", date)),
                new Document("flightDate", new Document("$lt", nextDate)),
                new Document("airline", airline)
        ));
    }

    public List<Document> thirteenthQuery(String departureCon, String destinationCon, Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        Date nextDate = c.getTime();
        return Arrays.asList(new Document("$match", new Document("$and",Arrays.asList(
                new Document("departure.country", departureCon),
                new Document("destination.country", destinationCon),
                new Document("flightDate", new Document("$gte", date)),
                new Document("flightDate", new Document("$lt", nextDate)))))
                , new Document("$project", new Document("_id", 0)
                        .append("departure.airport", 1)
                        .append("destination.airport", 1)
                )
        );
    }

    public List<Document> sortQuery(List<Document> docs, boolean ascOrDesc, boolean dateOrCost){
        ArrayList<Document> documents = new ArrayList<Document>(docs);
        if(ascOrDesc && dateOrCost) {
            documents.add( new Document("$sort", new Document("flightDate", 1)));
        }
        if(!ascOrDesc && dateOrCost) {
            documents.add(new Document("$sort", new Document("flightDate", -1)));
        }
        if(ascOrDesc && !dateOrCost) {
            documents.add(new Document("$sort", new Document("cost", 1)));
        }
        if(!ascOrDesc && !dateOrCost) {
            documents.add(new Document("$sort", new Document("cost", -1)));
        }
        return documents;
    }
}

