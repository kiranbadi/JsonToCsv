package com.kiran.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kiran.helpers.HdfsResultDeserializer;

import java.util.Arrays;
import java.util.List;

@JsonDeserialize(using = HdfsResultDeserializer.class)
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
    public List<String> snapshottedDirs = Arrays.asList("");
    @JsonProperty("failedFiles")
    public List<Object> failedFiles = Arrays.asList("");
    @JsonProperty("runAsUser")
    public String runAsUser="";

    public HdfsResult() {
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getThroughput() {
        return throughput;
    }

    public void setThroughput(String throughput) {
        this.throughput = throughput;
    }

    public String getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(String remainingTime) {
        this.remainingTime = remainingTime;
    }

    public String getNumBytesDryRun() {
        return numBytesDryRun;
    }

    public void setNumBytesDryRun(String numBytesDryRun) {
        this.numBytesDryRun = numBytesDryRun;
    }

    public String getNumFilesDryRun() {
        return numFilesDryRun;
    }

    public void setNumFilesDryRun(String numFilesDryRun) {
        this.numFilesDryRun = numFilesDryRun;
    }

    public String getNumFilesExpected() {
        return numFilesExpected;
    }

    public void setNumFilesExpected(String numFilesExpected) {
        this.numFilesExpected = numFilesExpected;
    }

    public String getNumBytesExpected() {
        return numBytesExpected;
    }

    public void setNumBytesExpected(String numBytesExpected) {
        this.numBytesExpected = numBytesExpected;
    }

    public String getNumFilesCopied() {
        return numFilesCopied;
    }

    public void setNumFilesCopied(String numFilesCopied) {
        this.numFilesCopied = numFilesCopied;
    }

    public String getNumBytesCopied() {
        return numBytesCopied;
    }

    public void setNumBytesCopied(String numBytesCopied) {
        this.numBytesCopied = numBytesCopied;
    }

    public String getNumFilesSkipped() {
        return numFilesSkipped;
    }

    public void setNumFilesSkipped(String numFilesSkipped) {
        this.numFilesSkipped = numFilesSkipped;
    }

    public String getNumBytesSkipped() {
        return numBytesSkipped;
    }

    public void setNumBytesSkipped(String numBytesSkipped) {
        this.numBytesSkipped = numBytesSkipped;
    }

    public String getNumFilesDeleted() {
        return numFilesDeleted;
    }

    public void setNumFilesDeleted(String numFilesDeleted) {
        this.numFilesDeleted = numFilesDeleted;
    }

    public String getNumFilesCopyFailed() {
        return numFilesCopyFailed;
    }

    public void setNumFilesCopyFailed(String numFilesCopyFailed) {
        this.numFilesCopyFailed = numFilesCopyFailed;
    }

    public String getNumBytesCopyFailed() {
        return numBytesCopyFailed;
    }

    public void setNumBytesCopyFailed(String numBytesCopyFailed) {
        this.numBytesCopyFailed = numBytesCopyFailed;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobDetailsUri() {
        return jobDetailsUri;
    }

    public void setJobDetailsUri(String jobDetailsUri) {
        this.jobDetailsUri = jobDetailsUri;
    }

    public String getDryRun() {
        return dryRun;
    }

    public void setDryRun(String dryRun) {
        this.dryRun = dryRun;
    }

    public List<String> getSnapshottedDirs() {
        return snapshottedDirs;
    }

    public void setSnapshottedDirs(List<String> snapshottedDirs) {
        this.snapshottedDirs = snapshottedDirs;
    }

    public List<Object> getFailedFiles() {
        return failedFiles;
    }

    public void setFailedFiles(List<Object> failedFiles) {
        this.failedFiles = failedFiles;
    }

    public String getRunAsUser() {
        return runAsUser;
    }

    public void setRunAsUser(String runAsUser) {
        this.runAsUser = runAsUser;
    }

    @Override
    public String toString() {
        return "HdfsResult{" +
                "progress='" + progress + '\'' +
                ", throughput='" + throughput + '\'' +
                ", remainingTime='" + remainingTime + '\'' +
                ", numBytesDryRun='" + numBytesDryRun + '\'' +
                ", numFilesDryRun='" + numFilesDryRun + '\'' +
                ", numFilesExpected='" + numFilesExpected + '\'' +
                ", numBytesExpected='" + numBytesExpected + '\'' +
                ", numFilesCopied='" + numFilesCopied + '\'' +
                ", numBytesCopied='" + numBytesCopied + '\'' +
                ", numFilesSkipped='" + numFilesSkipped + '\'' +
                ", numBytesSkipped='" + numBytesSkipped + '\'' +
                ", numFilesDeleted='" + numFilesDeleted + '\'' +
                ", numFilesCopyFailed='" + numFilesCopyFailed + '\'' +
                ", numBytesCopyFailed='" + numBytesCopyFailed + '\'' +
                ", jobId='" + jobId + '\'' +
                ", jobDetailsUri='" + jobDetailsUri + '\'' +
                ", dryRun='" + dryRun + '\'' +
                ", snapshottedDirs=" + snapshottedDirs +
                ", failedFiles=" + failedFiles +
                ", runAsUser='" + runAsUser + '\'' +
                '}';
    }
}
