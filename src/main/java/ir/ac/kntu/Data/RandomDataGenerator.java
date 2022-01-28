package ir.ac.kntu.Data;

public class RandomDataGenerator {

    public final Address[] addresses = {new Address("Turkey","Istanbul","IST"),
                                        new Address("Turkey","Ankara","ESB"),
                                        new Address("Emirates","Dubai","DXB"),
                                        new Address("Emirates","Abu Dhabi","AUH"),
                                        new Address("Qatar","Duha","DOH"),
                                        new Address("Iraq","Baghdad","BGW"),
                                        new Address("Germany","Frankfurt","FRA"),
                                        new Address("England","London","LHR"),
                                        new Address("China","Beijing","PEK")};

    public final String[] airlines = {"IranAir","Turkish Airline","Qatar Airways","Pegasus","Lufthansa","Mahan","Fly Emirates"};

    public final String[] flightTypes = {"economy","business","first class"};

    public Flight randomFlight(){
        return new Flight()
    }

    public String departFrom(){

    }

}
