package com.ytw.arbione.api.integration.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "instId"
})
public class Tickers {
    public Tickers(String instId) {
        this.instId = instId;
    }

    @JsonProperty("instType")
    private String instType;
    @JsonProperty("instId")
    private String instId;
    @JsonProperty("last")
    private String last;
    @JsonProperty("lastSz")
    private String lastSz;
    @JsonProperty("askPx")
    private String askPx;
    @JsonProperty("askSz")
    private String askSz;
    @JsonProperty("bidPx")
    private String bidPx;
    @JsonProperty("bidSz")
    private String bidSz;
    @JsonProperty("open24h")
    private String open24h;
    @JsonProperty("high24h")
    private String high24h;
    @JsonProperty("low24h")
    private String low24h;
    @JsonProperty("volCcy24h")
    private String volCcy24h;
    @JsonProperty("vol24h")
    private String vol24h;
    @JsonProperty("ts")
    private String ts;
    @JsonProperty("sodUtc0")
    private String sodUtc0;
    @JsonProperty("sodUtc8")
    private String sodUtc8;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("instType")
    public String getInstType() {
        return instType;
    }

    @JsonProperty("instType")
    public void setInstType(String instType) {
        this.instType = instType;
    }

    @JsonProperty("instId")
    public String getInstId() {
        return instId;
    }

    @JsonProperty("instId")
    public void setInstId(String instId) {
        this.instId = instId;
    }

    @JsonProperty("last")
    public String getLast() {
        return last;
    }

    @JsonProperty("last")
    public void setLast(String last) {
        this.last = last;
    }

    @JsonProperty("lastSz")
    public String getLastSz() {
        return lastSz;
    }

    @JsonProperty("lastSz")
    public void setLastSz(String lastSz) {
        this.lastSz = lastSz;
    }

    @JsonProperty("askPx")
    public String getAskPx() {
        return askPx;
    }

    @JsonProperty("askPx")
    public void setAskPx(String askPx) {
        this.askPx = askPx;
    }

    @JsonProperty("askSz")
    public String getAskSz() {
        return askSz;
    }

    @JsonProperty("askSz")
    public void setAskSz(String askSz) {
        this.askSz = askSz;
    }

    @JsonProperty("bidPx")
    public String getBidPx() {
        return bidPx;
    }

    @JsonProperty("bidPx")
    public void setBidPx(String bidPx) {
        this.bidPx = bidPx;
    }

    @JsonProperty("bidSz")
    public String getBidSz() {
        return bidSz;
    }

    @JsonProperty("bidSz")
    public void setBidSz(String bidSz) {
        this.bidSz = bidSz;
    }

    @JsonProperty("open24h")
    public String getOpen24h() {
        return open24h;
    }

    @JsonProperty("open24h")
    public void setOpen24h(String open24h) {
        this.open24h = open24h;
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

    @JsonProperty("volCcy24h")
    public String getVolCcy24h() {
        return volCcy24h;
    }

    @JsonProperty("volCcy24h")
    public void setVolCcy24h(String volCcy24h) {
        this.volCcy24h = volCcy24h;
    }

    @JsonProperty("vol24h")
    public String getVol24h() {
        return vol24h;
    }

    @JsonProperty("vol24h")
    public void setVol24h(String vol24h) {
        this.vol24h = vol24h;
    }

    @JsonProperty("ts")
    public String getTs() {
        return ts;
    }

    @JsonProperty("ts")
    public void setTs(String ts) {
        this.ts = ts;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public static class Builder {
        private Tickers tickers;

        public Builder(String instId) {
            tickers = new Tickers(instId);
        }

        public Builder instType(String instType) {
            tickers.setInstType(instType);
            return this;
        }

        public Builder last(String last) {
            tickers.setLast(last);
            return this;
        }

        public Builder lastSz(String lastSz) {
            tickers.setLastSz(lastSz);
            return this;
        }

        public Builder askPx(String askPx) {
            tickers.setAskPx(askPx);
            return this;
        }

        public Builder askSz(String askSz) {
            tickers.setAskSz(askSz);
            return this;
        }

        public Builder bidPx(String bidPx) {
            tickers.setBidPx(bidPx);
            return this;
        }

        public Builder bidSz(String bidSz) {
            tickers.setBidSz(bidSz);
            return this;
        }

        public Builder open24h(String open24h) {
            tickers.setOpen24h(open24h);
            return this;
        }

        public Builder high24h(String high24h) {
            tickers.setHigh24h(high24h);
            return this;
        }

        public Builder low24h(String low24h) {
            tickers.setLow24h(low24h);
            return this;
        }

        public Builder volCcy24h(String volCcy24h) {
            tickers.setVolCcy24h(volCcy24h);
            return this;
        }

        public Builder vol24h(String vol24h) {
            tickers.setVol24h(vol24h);
            return this;
        }

        public Builder ts(String ts) {
            tickers.setTs(ts);
            return this;
        }

        public Builder sodUtc0(String sodUtc0) {
            tickers.setSodUtc0(sodUtc0);
            return this;
        }

        public Builder sodUtc8(String sodUtc8) {
            tickers.setSodUtc8(sodUtc8);
            return this;
        }

        public Tickers build() {
            return tickers;
        }
    }

    @Override
    public String toString() {
        return "OkexTickersDatumPOJO{" +
                "instType='" + instType + '\'' +
                ", instId='" + instId + '\'' +
                ", last='" + last + '\'' +
                ", lastSz='" + lastSz + '\'' +
                ", askPx='" + askPx + '\'' +
                ", askSz='" + askSz + '\'' +
                ", bidPx='" + bidPx + '\'' +
                ", bidSz='" + bidSz + '\'' +
                ", open24h='" + open24h + '\'' +
                ", high24h='" + high24h + '\'' +
                ", low24h='" + low24h + '\'' +
                ", volCcy24h='" + volCcy24h + '\'' +
                ", vol24h='" + vol24h + '\'' +
                ", ts='" + ts + '\'' +
                ", sodUtc0='" + sodUtc0 + '\'' +
                ", sodUtc8='" + sodUtc8 + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
