package com.ytw.arbione.api.integration.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bids",
        "asks"
})
public class Book {
    public Book(List<List<String>> asks, List<List<String>> bids) {
        this.asks = asks;
        this.bids = bids;
    }

    @JsonProperty("asks")
    private List<List<String>> asks = null;
    @JsonProperty("bids")
    private List<List<String>> bids = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("asks")
    public List<List<String>> getAsks() {
        return asks;
    }

    @JsonProperty("asks")
    public void setAsks(List<List<String>> asks) {
        this.asks = asks;
    }

    @JsonProperty("bids")
    public List<List<String>> getBids() {
        return bids;
    }

    @JsonProperty("bids")
    public void setBids(List<List<String>> bids) {
        this.bids = bids;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Book{" +
                "asks=" + asks +
                ", bids=" + bids +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
