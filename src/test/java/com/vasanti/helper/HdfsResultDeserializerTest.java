package com.vasanti.helper;

import com.vasanti.model.HdfsResult;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class HdfsResultDeserializerTest {

    @Mock
    private JsonParser jsonParser;

    @Mock
    private ObjectCodec objectCodec;

    @Mock
    private DeserializationContext deserializationContext;

    @InjectMocks
    private HdfsResultDeserializer hdfsResultDeserializer;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    // Add tests here
    @Test
    void deserialize_shouldCorrectlyParseHdfsResult() throws IOException {
        // Given
        String json = "{\"progress\":\"100%\",\"throughput\":\"100MB/s\",\"remainingTime\":\"0s\",\"numBytesDryRun\":\"500MB\",\"numFilesDryRun\":\"5\",\"numFilesExpected\":\"10\",\"numBytesExpected\":\"1GB\",\"numFilesCopied\":\"10\",\"numBytesCopied\":\"1GB\",\"numFilesSkipped\":\"0\",\"numBytesSkipped\":\"0\",\"numFilesDeleted\":\"0\",\"numFilesCopyFailed\":\"0\",\"numBytesCopyFailed\":\"0\",\"jobId\":\"123\",\"jobDetailsUri\":\"http://example.com\",\"dryRun\":\"false\",\"snapshottedDirs\":[\"/dir1\",\"/dir2\"],\"failedFiles\":[],\"runAsUser\":\"user\"}";
        JsonNode node = new ObjectMapper().readTree(json);
        when(jsonParser.getCodec()).thenReturn(objectCodec);
        when(objectCodec.readTree(jsonParser)).thenReturn(node);
        HdfsResult result = hdfsResultDeserializer.deserialize(jsonParser, deserializationContext);
        Assertions.assertEquals("100%", result.getProgress());
        Assertions.assertEquals("user", result.getRunAsUser());
    }


    @Test
    void deserialize_shouldThrowIOExceptionOnInvalidJson() throws IOException {
        when(jsonParser.getCodec()).thenReturn(objectCodec);
        when(objectCodec.readTree(jsonParser)).thenThrow(new IOException("Invalid JSON"));
        Assertions.assertThrows(IOException.class, () -> hdfsResultDeserializer.deserialize(jsonParser, deserializationContext));
    }
}