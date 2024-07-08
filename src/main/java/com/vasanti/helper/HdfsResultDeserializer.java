package com.vasanti.helper;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.vasanti.model.HdfsResult;
import lombok.extern.log4j.Log4j2;


import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Log4j2
public class HdfsResultDeserializer extends JsonDeserializer<HdfsResult> {
    @Override
    public HdfsResult deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        log.info("HdfsResultDeserializer node :{}",node.toString());
        HdfsResult hdfsResult = new HdfsResult();
        String progress = node.get("progress").asText();
        hdfsResult.setProgress(progress);

        String throughput = node.get("throughput").asText();
        hdfsResult.setThroughput(throughput);

        String remainingTime = node.get("remainingTime").asText();
        hdfsResult.setRemainingTime(remainingTime);

        String numBytesDryRun = node.get("numBytesDryRun").asText();
        hdfsResult.setNumBytesDryRun(numBytesDryRun);

        String numFilesDryRun = node.get("numFilesDryRun").asText();
        hdfsResult.setNumFilesDryRun(numFilesDryRun);

        String numFilesExpected = node.get("numFilesExpected").asText();
        hdfsResult.setNumFilesExpected(numFilesExpected);

        String numBytesExpected = node.get("numBytesExpected").asText();
        hdfsResult.setNumBytesExpected(numBytesExpected);

        String numFilesCopied = node.get("numFilesCopied").asText();
        hdfsResult.setNumFilesCopied(numFilesCopied);

        String numBytesCopied = node.get("numBytesCopied").asText();
        hdfsResult.setNumBytesCopied(numBytesCopied);

        String numFilesSkipped = node.get("numFilesSkipped").asText();
        hdfsResult.setNumFilesSkipped(numFilesSkipped);

        String numBytesSkipped = node.get("numBytesSkipped").asText();
        hdfsResult.setNumBytesSkipped(numBytesSkipped);

        String numFilesDeleted = node.get("numFilesDeleted").asText();
        hdfsResult.setNumFilesDeleted(numFilesDeleted);

        String numFilesCopyFailed = node.get("numFilesCopyFailed").asText();
        hdfsResult.setNumFilesCopyFailed(numFilesCopyFailed);

        String numBytesCopyFailed = node.get("numBytesCopyFailed").asText();
        hdfsResult.setNumBytesCopyFailed(numBytesCopyFailed);

        String jobId = node.get("jobId").asText();
        hdfsResult.setJobId(jobId);

        String jobDetailsUri = node.get("jobDetailsUri").asText();
        hdfsResult.setJobDetailsUri(jobDetailsUri);

        String dryRun = node.get("dryRun").asText();
        hdfsResult.setDryRun(dryRun);

        List<String> snapshottedDirs = Collections.singletonList(node.get("snapshottedDirs").asText());
        hdfsResult.setSnapshottedDirs(snapshottedDirs);

        List<Object> failedFiles = Collections.singletonList(node.get("failedFiles").asText());
        hdfsResult.setFailedFiles(failedFiles);

        String runAsUser = node.get("runAsUser").asText();
        hdfsResult.setRunAsUser(runAsUser);


        return hdfsResult;
    }
}