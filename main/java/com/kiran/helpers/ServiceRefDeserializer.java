package com.kiran.helpers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.kiran.model.ServiceRef;

import java.io.IOException;

public class ServiceRefDeserializer extends JsonDeserializer<ServiceRef>
{

    @Override
    public ServiceRef deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        System.out.println(node.toString());

        ServiceRef serviceRef = new ServiceRef();
        String clusterName = node.get("clusterName").toString();
        serviceRef.setClusterName(clusterName);

        String serviceName = node.get("serviceName").toString();
        serviceRef.setServiceName(serviceName);


        return serviceRef;
    }
}
