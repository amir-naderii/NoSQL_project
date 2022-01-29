package ir.ac.kntu.Data;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.*;

public class Query {

    public DBCursor firstQuery(DBCollection collection, Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        Date nextDate = c.getTime();
        System.out.println(date.toString());
        System.out.println(nextDate.toString());
        BasicDBObject firstQuery = new BasicDBObject("$and", Arrays.asList(
                new BasicDBObject("flightDate", new BasicDBObject("$gte",date)),
                new BasicDBObject("flightDate",  new BasicDBObject("$lt", nextDate))));
        return collection.find(firstQuery);

    }

    public DBCursor secondQuery(DBCollection collection, int priceFrom,int priceTo){
        BasicDBObject secondQuery = new BasicDBObject("$and", Arrays.asList(
                new BasicDBObject("cost", new BasicDBObject("$gte",priceFrom)),
                new BasicDBObject("cost",  new BasicDBObject("$lt", priceTo))));
        return collection.find(secondQuery);
    }

    public DBCursor thirdQuery(DBCollection collection, String departure, String destination){
        BasicDBObject thirdQuery = new BasicDBObject("$and", Arrays.asList(
                new BasicDBObject("departure.city",departure),
                 new BasicDBObject("destination.city", destination)));
        return collection.find(thirdQuery);
    }

    public DBCursor forthQuery(DBCollection collection, )
    }

