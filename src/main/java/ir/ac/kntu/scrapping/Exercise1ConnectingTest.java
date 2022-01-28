package ir.ac.kntu.scrapping;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class Exercise1ConnectingTest {
    @Test
    public void shouldCreateANewMongoClientConnectedToLocalhost() {
        // When
        // TODO: get/create the MongoClient
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

        // Then
        assertThat(mongoClient, is(notNullValue()));
    }
}