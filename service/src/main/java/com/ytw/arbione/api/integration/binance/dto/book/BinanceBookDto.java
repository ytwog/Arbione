package com.ytw.arbione.api.integration.binance.dto.book;

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
        "lastUpdateId",
        "bids",
        "asks"
})
@Generated("jsonschema2pojo")
public class BinanceBookDto {

    @JsonProperty("lastUpdateId")
    private Long lastUpdateId;
    @JsonProperty("bids")
    private List<List<String>> bids = null;
    @JsonProperty("asks")
    private List<List<String>> asks = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("lastUpdateId")
    public Long getLastUpdateId() {
        return lastUpdateId;
    }

    @JsonProperty("lastUpdateId")
    public void setLastUpdateId(Long lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    @JsonProperty("bids")
    public List<List<String>> getBids() {
        return bids;
    }

    @JsonProperty("bids")
    public void setBids(List<List<String>> bids) {
        this.bids = bids;
    }

    @JsonProperty("asks")
    public List<List<String>> getAsks() {
        return asks;
    }

    @JsonProperty("asks")
    public void setAsks(List<List<String>> asks) {
        this.asks = asks;
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
        StringBuilder sb = new StringBuilder();
        sb.append(BinanceBookDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lastUpdateId");
        sb.append('=');
        sb.append(((this.lastUpdateId == null)?"<null>":this.lastUpdateId));
        sb.append(',');
        sb.append("bids");
        sb.append('=');
        sb.append(((this.bids == null)?"<null>":this.bids));
        sb.append(',');
        sb.append("asks");
        sb.append('=');
        sb.append(((this.asks == null)?"<null>":this.asks));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.bids == null)? 0 :this.bids.hashCode()));
        result = ((result* 31)+((this.lastUpdateId == null)? 0 :this.lastUpdateId.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.asks == null)? 0 :this.asks.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BinanceBookDto) == false) {
            return false;
        }
        BinanceBookDto rhs = ((BinanceBookDto) other);
        return (((((this.bids == rhs.bids)||((this.bids!= null)&&this.bids.equals(rhs.bids)))&&((this.lastUpdateId == rhs.lastUpdateId)||((this.lastUpdateId!= null)&&this.lastUpdateId.equals(rhs.lastUpdateId))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.asks == rhs.asks)||((this.asks!= null)&&this.asks.equals(rhs.asks))));
    }

}