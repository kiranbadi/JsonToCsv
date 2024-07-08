package com.vasanti.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vasanti.helper.HdfsResultDeserializer;
import lombok.*;

import java.util.List;

@JsonDeserialize(using = HdfsResultDeserializer.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class HdfsResult{

    @JsonProperty("progress")
    public String progress ="";
    @JsonProperty("throughput")
    public String throughput ="";
    @JsonProperty("remainingTime")
    public String remainingTime="";
    @JsonProperty("numBytesDryRun")
    public String numBytesDryRun="";
    @JsonProperty("numFilesDryRun")
    public String numFilesDryRun="";
    @JsonProperty("numFilesExpected")
    public String numFilesExpected="";
    @JsonProperty("numBytesExpected")
    public String numBytesExpected="";
    @JsonProperty("numFilesCopied")
    public String numFilesCopied="";
    @JsonProperty("numBytesCopied")
    public String numBytesCopied="";
    @JsonProperty("numFilesSkipped")
    public String numFilesSkipped="";
    @JsonProperty("numBytesSkipped")
    public String numBytesSkipped="";
    @JsonProperty("numFilesDeleted")
    public String numFilesDeleted="";
    @JsonProperty("numFilesCopyFailed")
    public String numFilesCopyFailed="";
    @JsonProperty("numBytesCopyFailed")
    public String numBytesCopyFailed="";
    @JsonProperty("jobId")
    public String jobId="";
    @JsonProperty("jobDetailsUri")
    public String jobDetailsUri="";
    @JsonProperty("dryRun")
    public String dryRun="";
    @JsonProperty("snapshottedDirs")
    public List<String> snapshottedDirs = List.of("");
    @JsonProperty("failedFiles")
    public List<Object> failedFiles = List.of("");
    @JsonProperty("runAsUser")
    public String runAsUser="";

}