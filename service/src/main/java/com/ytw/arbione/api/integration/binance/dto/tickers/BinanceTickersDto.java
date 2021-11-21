package com.ytw.arbione.api.integration.binance.dto.tickers;

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
import com.ytw.arbione.api.integration.binance.dto.BinanceExchangeFilterDto;
import com.ytw.arbione.api.integration.binance.dto.BinanceRateLimitDto;
import com.ytw.arbione.api.integration.binance.dto.tickers.BinanceSymbolDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "timezone",
        "serverTime",
        "rateLimits",
        "exchangeFilters",
        "symbols"
})
@Generated("jsonschema2pojo")
public class BinanceTickersDto {

    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("serverTime")
    private Long serverTime;
    @JsonProperty("rateLimits")
    private List<BinanceRateLimitDto> rateLimits = null;
    @JsonProperty("exchangeFilters")
    private List<BinanceExchangeFilterDto> exchangeFilters = null;
    @JsonProperty("symbols")
    private List<BinanceSymbolDto> symbols = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("serverTime")
    public Long getServerTime() {
        return serverTime;
    }

    @JsonProperty("serverTime")
    public void setServerTime(Long serverTime) {
        this.serverTime = serverTime;
    }

    @JsonProperty("rateLimits")
    public List<BinanceRateLimitDto> getRateLimits() {
        return rateLimits;
    }

    @JsonProperty("rateLimits")
    public void setRateLimits(List<BinanceRateLimitDto> rateLimits) {
        this.rateLimits = rateLimits;
    }

    @JsonProperty("exchangeFilters")
    public List<BinanceExchangeFilterDto> getExchangeFilters() {
        return exchangeFilters;
    }

    @JsonProperty("exchangeFilters")
    public void setExchangeFilters(List<BinanceExchangeFilterDto> exchangeFilters) {
        this.exchangeFilters = exchangeFilters;
    }

    @JsonProperty("symbols")
    public List<BinanceSymbolDto> getSymbols() {
        return symbols;
    }

    @JsonProperty("symbols")
    public void setSymbols(List<BinanceSymbolDto> symbols) {
        this.symbols = symbols;
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
        return "BinanceTickersDto{" +
                "timezone='" + timezone + '\'' +
                ", serverTime=" + serverTime +
                ", rateLimits=" + rateLimits +
                ", exchangeFilters=" + exchangeFilters +
                ", symbols=" + symbols +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}