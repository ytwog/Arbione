package com.ytw.arbione.api.integration.okex.dto.index;

import java.util.HashMap;
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
        "instId",
        "idxPx",
        "high24h",
        "low24h",
        "open24h",
        "sodUtc0",
        "sodUtc8",
        "ts"
})
@Generated("jsonschema2pojo")
public class OkexIndexTickersDatumDto {

    @JsonProperty("instId")
    private String instId;
    @JsonProperty("idxPx")
    private String idxPx;
    @JsonProperty("high24h")
    private String high24h;
    @JsonProperty("low24h")
    private String low24h;
    @JsonProperty("open24h")
    private String open24h;
    @JsonProperty("sodUtc0")
    private String sodUtc0;
    @JsonProperty("sodUtc8")
    private String sodUtc8;
    @JsonProperty("ts")
    private String ts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("instId")
    public String getInstId() {
        return instId;
    }

    @JsonProperty("instId")
    public void setInstId(String instId) {
        this.instId = instId;
    }

    @JsonProperty("idxPx")
    public String getIdxPx() {
        return idxPx;
    }

    @JsonProperty("idxPx")
    public void setIdxPx(String idxPx) {
        this.idxPx = idxPx;
    }

    @JsonProperty("high24h")
    public String getHigh24h() {
        return high24h;
    }

    @JsonProperty("high24h")
    public void setHigh24h(String high24h) {
        this.high24h = high24h;
    }

    @JsonProperty("low24h")
    public String getLow24h() {
        return low24h;
    }

    @JsonProperty("low24h")
    public void setLow24h(String low24h) {
        this.low24h = low24h;
    }

    @JsonProperty("open24h")
    public String getOpen24h() {
        return open24h;
    }

    @JsonProperty("open24h")
    public void setOpen24h(String open24h) {
        this.open24h = open24h;
    }

    @JsonProperty("sodUtc0")
    public String getSodUtc0() {
        return sodUtc0;
    }

    @JsonProperty("sodUtc0")
    public void setSodUtc0(String sodUtc0) {
        this.sodUtc0 = sodUtc0;
    }

    @JsonProperty("sodUtc8")
    public String getSodUtc8() {
        return sodUtc8;
    }

    @JsonProperty("sodUtc8")
    public void setSodUtc8(String sodUtc8) {
        this.sodUtc8 = sodUtc8;
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
        return "OkexIndexTickersDatumPOJO{" +
                "instId='" + instId + '\'' +
                ", idxPx='" + idxPx + '\'' +
                ", high24h='" + high24h + '\'' +
                ", low24h='" + low24h + '\'' +
                ", open24h='" + open24h + '\'' +
                ", sodUtc0='" + sodUtc0 + '\'' +
                ", sodUtc8='" + sodUtc8 + '\'' +
                ", ts='" + ts + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}