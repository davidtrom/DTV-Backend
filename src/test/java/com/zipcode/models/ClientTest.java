package com.zipcode.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.Entity;

public class ClientTest {

    private Client testClient;

    @BeforeEach
    void setUp() {
        testClient = new Client("FirstName", "LastName","myemail@gmail.com");
    }

    @Test
    public void testClassSignatureAnnotations() {
        Assertions.assertTrue(Client.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Client client = new Client();
        String json = jsonWriter.writeValueAsString(client);
    }

    @Test
    void getFirstName() {
        String expected = "FirstName";
        String actual = testClient.getFirstName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getLastName() {
        String expected = "LastName";
        String actual = testClient.getLastName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getEmail() {
        String expected = "myemail@gmail.com";
        String actual = testClient.getEmail();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setFirstName() {
        String expected = "NewFirstName";
        testClient.setFirstName(expected);
        String actual = testClient.getFirstName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setLastName() {
        String expected = "NewLastName";
        testClient.setLastName(expected);
        String actual = testClient.getLastName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setEmail() {
        String expected = "myNewEmail@gmail.com";
        testClient.setEmail(expected);
        String actual = testClient.getEmail();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setEmail2() {
        //email won't get changed because it's invalid
        String expected = "myNewEmail@";
        testClient.setEmail(expected);
        String actual = testClient.getEmail();
        Assertions.assertEquals("myemail@gmail.com", actual);
    }

}
