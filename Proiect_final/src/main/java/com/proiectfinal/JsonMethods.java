package com.proiectfinal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class JsonMethods {
    private static ObjectMapper mapper = getDefaultMapper();
    public static ObjectMapper getDefaultMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    public static JsonNode parse(String src) throws IOException {
        return mapper.readTree(src);
    }

    public static <A>A fromJson(JsonNode node, Class<A> clasa){
        try {
            return mapper.treeToValue(node, clasa);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public static JsonNode toJson(Object a){
        return mapper.valueToTree(a);
    }
    public static String stringify(JsonNode node) throws JsonProcessingException {
        ObjectWriter writer = mapper.writer();
        writer = writer.with(SerializationFeature.INDENT_OUTPUT);
        return writer.writeValueAsString(node);
    }

}
