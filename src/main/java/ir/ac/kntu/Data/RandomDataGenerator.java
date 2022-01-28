package ir.ac.kntu.Data;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import ir.ac.kntu.scrapping.FlightDB;
import ir.ac.kntu.scrapping.MongoDBSetUp;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class RandomDataGenerator {

    public final Address[] addresses = {new Address("Turkey","Istanbul","IST"),
                                        new Address("Turkey","Ankara","ESB"),
                                        new Address("Emirates","Dubai","DXB"),
                                        new Address("Emirates","Abu Dhabi","AUH"),
                                        new Address("Qatar","Doha","DOH"),
                                        new Address("Iraq","Baghdad","BGW"),
                                        new Address("Germany","Frankfurt","FRA"),
                                        new Address("England","London","LHR"),
                                        new Address("China","Beijing","PEK")};
    public final Address[] iranAddresses = {new Address("Iran","Tehran","IKA"),
                                            new Address("Iran","Mashhad","MHD"),
                                            new Address("Iran","Shiraz","SYZ"),
                                            new Address("Iran","Isfahan","IFN"),};

    public final String[] airlines = {"IranAir","Turkish Airline","Qatar Airways","Pegasus",
            "Lufthansa","Mahan","Fly Emirates"};

    public final String[] flightTypes = {"economy","business","first class"};

    public Flight randomFlight(){
        Random random = new Random();
        int flightId = random.nextInt(900);
        flightId +=100;
        int addressInx = random.nextInt(addresses.length);
        int iranAddressInx = random.nextInt(iranAddresses.length);
        Date flightDate = new Date(2022, Calendar.MARCH,random.nextInt(7)+1,
                random.nextInt(24), random.nextInt(60));
        Date arrivalDate = new Date(2022, Calendar.MARCH,random.nextInt(7)+1,
                random.nextInt(24), random.nextInt(60));
        int airlineInx = random.nextInt(airlines.length);
        int flightTypeInx = random.nextInt(flightTypes.length);
        return new Flight(Integer.toString(flightId), addresses[addressInx],
                iranAddresses[iranAddressInx], flightDate,airlines[airlineInx]
                ,arrivalDate, flightTypes[flightTypeInx], random.nextInt(221)+80,
                random.nextInt(401) + 100);
    }

    public void generate(int n){
        for (int i = 0; i < n; i++) {
            DBObject flight = FlightDB.toDBObject(randomFlight());
            DB db = MongoDBSetUp.getInstance().getDB("FlightDataBase");
            DBCollection collection = db.getCollection("flights");
            collection.insert(flight);
        }
    }

}
