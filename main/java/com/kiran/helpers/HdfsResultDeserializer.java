package com.kiran.helpers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.kiran.model.HdfsResult;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HdfsResultDeserializer extends JsonDeserializer<HdfsResult> {
    @Override
    public HdfsResult deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        System.out.println(node.toString());
        if(node == null){
            HdfsResult hdfsResult = new HdfsResult();
            return hdfsResult;
        }
        else {
            HdfsResult hdfsResult = new HdfsResult();

            String progress = node.get("progress").toString();
            hdfsResult.setProgress(progress);

            String throughput = node.get("throughput").toString();
            hdfsResult.setThroughput(throughput);

            String remainingTime = node.get("remainingTime").toString();
            hdfsResult.setRemainingTime(remainingTime);

            String numBytesDryRun = node.get("numBytesDryRun").toString();
            hdfsResult.setNumBytesDryRun(numBytesDryRun);

            String numFilesDryRun = node.get("numFilesDryRun").toString();
            hdfsResult.setNumFilesDryRun(numFilesDryRun);

            String numFilesExpected = node.get("numFilesExpected").toString();
            hdfsResult.setNumFilesExpected(numFilesExpected);

            String numBytesExpected = node.get("numBytesExpected").toString();
            hdfsResult.setNumBytesExpected(numBytesExpected);

            String numFilesCopied = node.get("numFilesCopied").toString();
            hdfsResult.setNumFilesCopied(numFilesCopied);

            String numBytesCopied = node.get("numBytesCopied").toString();
            hdfsResult.setNumBytesCopied(numBytesCopied);

            String numFilesSkipped = node.get("numFilesSkipped").toString();
            hdfsResult.setNumFilesSkipped(numFilesSkipped);

            String numBytesSkipped = node.get("numBytesSkipped").toString();
            hdfsResult.setNumBytesSkipped(numBytesSkipped);

            String numFilesDeleted = node.get("numFilesDeleted").toString();
            hdfsResult.setNumFilesDeleted(numFilesDeleted);

            String numFilesCopyFailed = node.get("numFilesCopyFailed").toString();
            hdfsResult.setNumFilesCopyFailed(numFilesCopyFailed);

            String numBytesCopyFailed = node.get("numBytesCopyFailed").toString();
            hdfsResult.setNumBytesCopyFailed(numBytesCopyFailed);

            String jobId = node.get("jobId").toString();
            hdfsResult.setJobId(jobId);

            String jobDetailsUri = node.get("jobDetailsUri").toString();
            hdfsResult.setJobDetailsUri(jobDetailsUri);

            String dryRun = node.get("dryRun").toString();
            hdfsResult.setDryRun(dryRun);

            List<String> snapshottedDirs = Arrays.asList(node.get("snapshottedDirs").toString());
            hdfsResult.setSnapshottedDirs(snapshottedDirs);

            List<Object> failedFiles = Arrays.asList(node.get("failedFiles").toString());
            hdfsResult.setFailedFiles(failedFiles);

            String runAsUser = node.get("runAsUser").toString();
            hdfsResult.setRunAsUser(runAsUser);


            return hdfsResult;
        }
    }
}
