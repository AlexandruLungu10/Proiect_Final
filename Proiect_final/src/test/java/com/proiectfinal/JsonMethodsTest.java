package com.proiectfinal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.proiectfinal.toObject.TestFisier;
import com.proiectfinal.toObject.TestToObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonMethodsTest {
    private String simpleTest = "{\n" +
            "  \"titlu\": \"Test\",\n" +
            "  \"autor\": \"Alex\"\n" +
            "}";
    private String testFisier1 = "{\n" +
            "  \"date\": \"2025-03-18\",\n" +
            "  \"name\": \"Data Random\"\n" +
            "}";
    @Test
    void parse() throws IOException {
        JsonNode node = JsonMethods.parse(simpleTest);
        assertEquals(node.get("title").asText(), "Parse Test");
    }

    @Test
    void fromJson() throws IOException {
        JsonNode node = JsonMethods.parse(simpleTest);
        TestToObject testToObject = JsonMethods.fromJson(node, TestToObject.class);
        assertEquals(testToObject.getTitle(), "Parse Test");
    }
    @Test
    void toJson() throws IOException {
        TestToObject test = new TestToObject();
        test.setTitle("Titlu nou");
        JsonNode node = JsonMethods.toJson(test);
        assertEquals(node.get("title").asText(), "Titlu nou");
    }
    @Test
    void stringify() throws JsonProcessingException {
        TestToObject test = new TestToObject();
        test.setTitle("Titlu stringify");
        JsonNode node = JsonMethods.toJson(test);
        System.out.println(JsonMethods.stringify(node));
    }
    @Test
    void testFisiere1() throws IOException {
        JsonNode node = JsonMethods.parse(testFisier1);
        TestFisier testFisier = JsonMethods.fromJson(node, TestFisier.class);
        assertEquals("Tue Mar 18 02:00:00 EET 2025", testFisier.getDate().toString());
    }
}