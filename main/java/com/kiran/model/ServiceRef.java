package com.kiran.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kiran.helpers.ServiceRefDeserializer;


@JsonDeserialize(using=ServiceRefDeserializer.class)
public class ServiceRef{

    @JsonProperty("clusterName")
    public String clusterName;
    @JsonProperty("serviceName")
    public String serviceName;

    public String getClusterName() {
        return clusterName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public ServiceRef() {
    }

    public ServiceRef(String clusterName, String serviceName) {
        this.clusterName = clusterName;
        this.serviceName = serviceName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "ServiceRef{" +
                "clusterName='" + clusterName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
