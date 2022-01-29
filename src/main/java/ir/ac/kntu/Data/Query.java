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
        Date nextDate = (Date) date.clone();
        Calendar c = Calendar.getInstance();
        c.setTime(nextDate);
        c.add(Calendar.DATE, 1);
//        BasicDBObject firstQuery = new BasicDBObject("$and", Arrays.asList(
//                new BasicDBObject("flightDate", new BasicDBObject("$gte",date)),
//                new BasicDBObject("first_name",  new BasicDBObject("$lt", nextDate))));
        BasicDBObject firstQuery = new BasicDBObject("flightDate",date);
        return collection.find(firstQuery);

    }
//        return collection.find(new BasicDBObject({"flightDate",new BasicDBObject("$gte",new Date("2022-02-03T00:00:00.000Z"))
//                    "$lt": new Date("2022-02-04T00:00:00.000Z"

    }

