package com.kiran.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kiran.helpers.HdfsResultDeserializer;
import com.kiran.helpers.ServiceRefDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item{

    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("startTime")
    public String startTime;
    @JsonProperty("active")
    public String active;

    @JsonUnwrapped
    @JsonDeserialize(using = ServiceRefDeserializer.class)
    @JsonProperty("serviceRef")
    public ServiceRef serviceRef;

    @JsonProperty("endTime")
    public String endTime;

    @JsonProperty("success")
    public String success;

    @JsonProperty("resultMessage")
    public String resultMessage;

    @JsonProperty("resultDataUrl")
    public String resultDataUrl;

    @JsonUnwrapped
    @JsonProperty("hdfsResult")
    @JsonDeserialize (using= HdfsResultDeserializer.class)
    public HdfsResult hdfsResult;

    public Item() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public ServiceRef getServiceRef() {
        return serviceRef;
    }

    public void setServiceRef(ServiceRef serviceRef) {
        this.serviceRef = serviceRef;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultDataUrl() {
        return resultDataUrl;
    }

    public void setResultDataUrl(String resultDataUrl) {
        this.resultDataUrl = resultDataUrl;
    }

    public HdfsResult getHdfsResult() {
        return hdfsResult;
    }

    public void setHdfsResult(HdfsResult hdfsResult) {
        this.hdfsResult = hdfsResult;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", startTime='" + startTime + '\'' +
                ", active='" + active + '\'' +
                ", serviceRef=" + serviceRef +
                ", endTime='" + endTime + '\'' +
                ", success='" + success + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                ", resultDataUrl='" + resultDataUrl + '\'' +
                ", hdfsResult=" + hdfsResult +
                '}';
    }
}
