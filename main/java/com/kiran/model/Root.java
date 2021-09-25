package com.kiran.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Root{

    @JsonProperty("items")
    @JsonIgnoreProperties
    public List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Root{" +
                "items=" + items +
                '}';
    }
}
