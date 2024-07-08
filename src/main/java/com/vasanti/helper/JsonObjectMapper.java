package com.vasanti.helper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.vasanti.model.HdfsResult;
import com.vasanti.model.ServiceRef;
import lombok.Getter;

@Getter
public class JsonObjectMapper {

    private static JsonObjectMapper instance;
    private final ObjectMapper objectMapper;

    private JsonObjectMapper() {
        SimpleModule mod = new SimpleModule();
        mod.addDeserializer(ServiceRef.class, new ServiceRefDeserializer());
        mod.addDeserializer(HdfsResult.class, new HdfsResultDeserializer());
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(mod);
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    }

    public static synchronized JsonObjectMapper getInstance() {
        if (instance == null) {
            instance = new JsonObjectMapper();
        }
        return instance;
    }
}
