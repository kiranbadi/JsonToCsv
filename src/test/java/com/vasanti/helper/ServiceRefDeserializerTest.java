package com.vasanti.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vasanti.model.ServiceRef;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ServiceRefDeserializerTest {

    @Mock
    private JsonParser jsonParser;

    @Mock
    private ObjectCodec objectCodec;

    @Mock
    private DeserializationContext deserializationContext;

    private AutoCloseable closeable;

    @InjectMocks
    private ServiceRefDeserializer serviceRefDeserializer;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void deserialize_withValidJson_returnsServiceRef() throws IOException {
        String json = "{\"clusterName\":\"TestCluster\",\"serviceName\":\"TestService\"}";
        JsonParser jsonParser = new ObjectMapper().createParser(json);
        DeserializationContext deserializationContext = mock(DeserializationContext.class);
        ServiceRef result = serviceRefDeserializer.deserialize(jsonParser, deserializationContext);
        assertEquals("TestCluster", result.getClusterName());
        assertEquals("TestService", result.getServiceName());
    }

    @Test
    void deserialize_throwsIOException() throws IOException {
        when(jsonParser.getCodec()).thenReturn(objectCodec);
        when(objectCodec.readTree(jsonParser)).thenThrow(new IOException("Invalid JSON"));
        assertThrows(IOException.class, () -> serviceRefDeserializer.deserialize(jsonParser, deserializationContext));
    }

    @Test
    void deserialize_withMissingClusterName() throws IOException {
        String json = "{\"serviceName\":\"TestService\"}";
        JsonParser jsonParser = new ObjectMapper().createParser(json);
        DeserializationContext deserializationContext = mock(DeserializationContext.class);
        ServiceRef result = serviceRefDeserializer.deserialize(jsonParser, deserializationContext);
        assertNull(result.getClusterName());

    }

    @Test
    void deserialize_withMissingServiceName_throwsIOException() throws IOException {
        String json = "{\"clusterName\":\"TestCluster\"}";
        JsonParser jsonParser = new ObjectMapper().createParser(json);
        DeserializationContext deserializationContext = mock(DeserializationContext.class);
        ServiceRef result = serviceRefDeserializer.deserialize(jsonParser, deserializationContext);
        assertNull(result.getServiceName());
    }
}