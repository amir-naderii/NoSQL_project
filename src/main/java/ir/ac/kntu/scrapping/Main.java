package ir.ac.kntu.scrapping;

import com.mongodb.*;
import ir.ac.kntu.Data.Flight;
import ir.ac.kntu.Data.RandomDataGenerator;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        randomDataGenerator.generate(100);
    }
}
