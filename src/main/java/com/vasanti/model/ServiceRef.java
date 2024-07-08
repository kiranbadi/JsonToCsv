package com.vasanti.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vasanti.helper.ServiceRefDeserializer;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
@JsonDeserialize(using= ServiceRefDeserializer.class)
public class ServiceRef{

    @JsonProperty("clusterName")
    private String clusterName;
    @JsonProperty("serviceName")
    private String serviceName;

}
