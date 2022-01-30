package ir.ac.kntu;

import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import ir.ac.kntu.Data.Query;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class Menu {
    MongoCollection collection;
    Scanner scanner;
    Query query;
    AggregateIterable<Document> iter;
    int year;

    public Menu(MongoCollection collection, Query query) {
        this.collection = collection;
        this.query = query;
        scanner = new Scanner(System.in);
        year = new Date().getYear();
    }

    public void printMenu() {
        System.out.println("-----------------------------------Welcome to FlightBoard!----------------------");
        System.out.println("What do you want to do?\n1: Find Flights by Date" +
                "\n2: Find Flights by Price\n3: Find Min&Max Price of Fights by Departure and Destination" +
                "\n4: Find Average&Total Price of Fights by Departure and Destination\n" +
                "5: Find Flights Price Range and Cheapest by Departure and Destination" +
                "\n6: Find Flights by Departure and Destination and Capacity\n" +
                "7: Find Airline by Departure and Destination and Date" +
                "\n8: Delete Flights by Date and Flight Agencies\n9: Change Flight Capacity by Id" +
                "\n10: Change Flights Capacity by Airline and Date and Departure and Destination\n" +
                "11: Find Airports by Country and Date\n12: Exit");
        menuControl(scanner.nextLine());
    }

    private void menuControl(String mode) {
        switch (mode) {
            case "1":
                System.out.println("Enter a Date: month day");
                Date date = new Date(year,
                        Integer.valueOf(scanner.nextLine()), Integer.valueOf(scanner.nextLine()));
                System.out.println("Do You Want To Add Class:");
                if (scanner.nextLine().equals("yes")) {
                    System.out.println("Enter Flight Class:");
                    showMode(query.fifthQuery(scanner.nextLine(), date,0,0,null,
                            null,null));
                    break;
                }
                showMode(query.firstQuery(date));
                break;
            case "2":
                System.out.println("Enter FirstPrice & SecondPrice:");
                System.out.println("Do You Want To Add Class:");
                if (scanner.nextLine().equals("yes")) {
                    System.out.println("Enter Flight Class:");
                    showMode(query.fifthQuery(scanner.nextLine(), null,Integer.valueOf(scanner.nextLine()),
                            Integer.valueOf(scanner.nextLine()),null,
                            null,null));
                    break;
                }
                showMode(query.secondQuery(Integer.valueOf(scanner.nextLine()), Integer.valueOf(
                        scanner.nextLine())));
                break;
            case "3":
                System.out.println("Enter Departure & Destination:");
                System.out.println("Do You Want To Add Class:");
                if (scanner.nextLine().equals("yes")) {
                    System.out.println("Enter Flight Class:");
                    showMode(query.fifthQuery(scanner.nextLine(), null,0,0
                            ,scanner.nextLine(), scanner.nextLine(),"max"));
                    break;
                }
                showMode(query.thirdQuery(scanner.nextLine(), scanner.nextLine()));
                break;
            case "4":
                System.out.println("Enter Departure & Destination:");
                System.out.println("Do You Want To Add Class:");
                if (scanner.nextLine().equals("yes")) {
                    System.out.println("Enter Flight Class:");
                    showMode(query.fifthQuery(scanner.nextLine(), null,0,0
                            ,scanner.nextLine(), scanner.nextLine(),"avr"));
                    break;
                }
                showMode(query.thirdQuery(scanner.nextLine(), scanner.nextLine()));
                break;
            case "5":
                System.out.println("Enter FirstPrice SecondPrice Departure Destination");
                System.out.println("Do You Want To Add Date?");
                if (scanner.nextLine().equals("yes")) {
                    System.out.println("Enter Flight FirstDate SecondDate:");
                    Date date1 = new Date(year,
                            Integer.valueOf(scanner.nextLine()), Integer.valueOf(scanner.nextLine()));
                    Date date2 = new Date(year,
                            Integer.valueOf(scanner.nextLine()), Integer.valueOf(scanner.nextLine()));
                    showMode(query.eighthQuery(date1,date2,scanner.nextLine(),scanner.nextLine(),
                            0,Integer.valueOf(scanner.nextLine()), Integer.valueOf(
                                    scanner.nextLine())));
                    break;
                }
                showMode(query.sixthQuery(Integer.valueOf(scanner.nextLine()),
                        Integer.valueOf(scanner.nextLine()),scanner.nextLine(), scanner.nextLine()));
                break;
            case "6":
                System.out.println("Enter Departure Destination Capacity");
                System.out.println("Do You Want To Add Date?");
                if (scanner.nextLine().equals("yes")) {
                    System.out.println("Enter Flight FirstDate SecondDate:");
                    Date date1 = new Date(year,
                            Integer.valueOf(scanner.nextLine()), Integer.valueOf(scanner.nextLine()));
                    Date date2 = new Date(year,
                            Integer.valueOf(scanner.nextLine()), Integer.valueOf(scanner.nextLine()));
                    showMode(query.eighthQuery(date1,date2,scanner.nextLine(),scanner.nextLine(),
                            Integer.valueOf(scanner.nextLine()),
                            0, 0));
                    break;
                }
                showMode(query.seventhQuery(scanner.nextLine(),scanner.nextLine(),
                        Integer.valueOf(scanner.nextLine())));
                break;
            case "7":
                System.out.println("Enter Departure Destination Date:");
                showMode(query.ninthQuery(scanner.nextLine(), scanner.nextLine(),
                        new Date(year,
                                Integer.valueOf(scanner.nextLine()),
                                Integer.valueOf(scanner.nextLine()))));
            case "8":
                System.out.println("Enter Date Airline");
                if (collection.deleteMany(query.tenthQuery(new Date(year,
                        Integer.valueOf(scanner.nextLine()),
                        Integer.valueOf(scanner.nextLine())), scanner.nextLine())).wasAcknowledged()) {
                    System.out.println("Objects Deleted");
                    break;
                }
                System.out.println("Error");
                break;
            case "9":
                System.out.println("Enter FlightId NewCapacity");
                if (collection.updateOne(query.eleventhQuery(scanner.nextLine())
                        ,query.updateCapacity(Integer.valueOf(scanner.nextLine()))).wasAcknowledged()) {
                    System.out.println("Objects Updated");
                    break;
                }
                System.out.println("Error");
                break;
            case "10":
                System.out.println("Enter Airline, Date Departure Destination");
                if (collection.updateOne(query.twelfthQuery(scanner.nextLine(),
                        new Date(year,
                        Integer.valueOf(scanner.nextLine()),
                        Integer.valueOf(scanner.nextLine())),
                        scanner.nextLine(), scanner.nextLine()),
                        query.updateCapacity(Integer.valueOf(scanner.nextLine()))).wasAcknowledged()) {
                    System.out.println("Objects Updated");
                    break;
                }
                System.out.println("Error");
                break;
            case "11":
                System.out.println("Enter DepartureCountry DestinationCountry Date");
                showMode(query.thirteenthQuery(scanner.nextLine(), scanner.nextLine(),
                        new Date(year,
                                Integer.valueOf(scanner.nextLine()),
                                Integer.valueOf(scanner.nextLine()))));
                break;
            case "12":
                System.exit(0);
        }
        printMenu();
    }

    private void showMode(List<Document> list) {
        System.out.println("Enter Show Mode: 1: Ascending/2: Descending");
        String in = scanner.nextLine();
        System.out.println("Enter Filter Mode: 1: Date/2: Cost");
        String filter = scanner.nextLine();
        System.out.println("Enter Page Number: ");
        int page = Integer.valueOf(scanner.nextLine());
        switch (in+filter) {
            case "11":
                pagingQuery(collection,query.sortQuery(list, true, true), page);
                break;
            case "12":
                pagingQuery(collection,query.sortQuery(list, true, false), page);
                break;
            case "21":
                pagingQuery(collection,query.sortQuery(list, false, true), page);
                break;
            case "22":
                pagingQuery(collection,query.sortQuery(list, false, false), page);
                break;
        }
    }

    public void pagingQuery(MongoCollection collection,
                            List<Document> documents, int pageSize){
        int size = (int) StreamSupport.stream(collection.aggregate(documents).spliterator()
                , false).count();
        int i = 0;
        while(size > 0){
            List<Document> result = new ArrayList<>(documents);
            result.add(
                    new Document("$skip", i*pageSize)
            );
            result.add(new Document("$limit", pageSize));
            collection.aggregate(result).forEach((Block<? super Document>)
                    doc -> System.out.println(doc.toJson()));
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Enter Any Key!");
            scanner.next();
            size -= pageSize;
            i++;
        }

    }

}
