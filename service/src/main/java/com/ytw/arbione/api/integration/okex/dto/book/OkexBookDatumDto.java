package com.ytw.arbione.api.integration.okex.dto.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "asks",
        "bids",
        "ts"
})
@Generated("jsonschema2pojo")
public class OkexBookDatumDto {

    @JsonProperty("asks")
    private List<List<String>> asks = null;
    @JsonProperty("bids")
    private List<List<String>> bids = null;
    @JsonProperty("ts")
    private String ts;
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

    @JsonProperty("ts")
    public String getTs() {
        return ts;
    }

    @JsonProperty("ts")
    public void setTs(String ts) {
        this.ts = ts;
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
        return "OkexBookDatumDto{" +
                "asks=" + asks +
                ", bids=" + bids +
                ", ts='" + ts + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}