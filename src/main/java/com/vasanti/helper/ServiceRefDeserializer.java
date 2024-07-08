package com.vasanti.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.vasanti.model.ServiceRef;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class ServiceRefDeserializer extends JsonDeserializer<ServiceRef> {
    @Override
    public ServiceRef deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        log.info("ServiceRefDeserializer node : {}",node.toString());
        ServiceRef serviceRef = new ServiceRef();
        String clusterName = node.has("clusterName") ? node.get("clusterName").asText()
                : null;
        serviceRef.setClusterName(clusterName);
        String serviceName = node.has("serviceName") ? node.get("serviceName").asText() : null;
        serviceRef.setServiceName(serviceName);
        return serviceRef;
    }
}
