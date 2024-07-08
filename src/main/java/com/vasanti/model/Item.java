package com.vasanti.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.vasanti.helper.HdfsResultDeserializer;
import com.vasanti.helper.ServiceRefDeserializer;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Item{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("active")
    private String active;

    @JsonUnwrapped
    @JsonDeserialize(using = ServiceRefDeserializer.class)
    @JsonProperty("serviceRef")
    private ServiceRef serviceRef;

    @JsonProperty("endTime")
    private String endTime;

    @JsonProperty("success")
    private String success;

    @JsonProperty("resultMessage")
    private String resultMessage;

    @JsonProperty("resultDataUrl")
    private String resultDataUrl;

    @JsonUnwrapped
    @JsonProperty("hdfsResult")
    @JsonDeserialize (using= HdfsResultDeserializer.class)
    private HdfsResult hdfsResult;

}
