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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "symbol",
        "status",
        "baseAsset",
        "baseAssetPrecision",
        "quoteAsset",
        "quotePrecision",
        "quoteAssetPrecision",
        "orderTypes",
        "icebergAllowed",
        "ocoAllowed",
        "isSpotTradingAllowed",
        "isMarginTradingAllowed",
        "filters",
        "permissions"
})
@Generated("jsonschema2pojo")
public class BinanceSymbolDto {

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("status")
    private String status;
    @JsonProperty("baseAsset")
    private String baseAsset;
    @JsonProperty("baseAssetPrecision")
    private Integer baseAssetPrecision;
    @JsonProperty("quoteAsset")
    private String quoteAsset;
    @JsonProperty("quotePrecision")
    private Integer quotePrecision;
    @JsonProperty("quoteAssetPrecision")
    private Integer quoteAssetPrecision;
    @JsonProperty("orderTypes")
    private List<String> orderTypes = null;
    @JsonProperty("icebergAllowed")
    private Boolean icebergAllowed;
    @JsonProperty("ocoAllowed")
    private Boolean ocoAllowed;
    @JsonProperty("isSpotTradingAllowed")
    private Boolean isSpotTradingAllowed;
    @JsonProperty("isMarginTradingAllowed")
    private Boolean isMarginTradingAllowed;
    @JsonProperty("filters")
    private List<BinanceSymbolDto> filters = null;
    @JsonProperty("permissions")
    private List<String> permissions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("baseAsset")
    public String getBaseAsset() {
        return baseAsset;
    }

    @JsonProperty("baseAsset")
    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    @JsonProperty("baseAssetPrecision")
    public Integer getBaseAssetPrecision() {
        return baseAssetPrecision;
    }

    @JsonProperty("baseAssetPrecision")
    public void setBaseAssetPrecision(Integer baseAssetPrecision) {
        this.baseAssetPrecision = baseAssetPrecision;
    }

    @JsonProperty("quoteAsset")
    public String getQuoteAsset() {
        return quoteAsset;
    }

    @JsonProperty("quoteAsset")
    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    @JsonProperty("quotePrecision")
    public Integer getQuotePrecision() {
        return quotePrecision;
    }

    @JsonProperty("quotePrecision")
    public void setQuotePrecision(Integer quotePrecision) {
        this.quotePrecision = quotePrecision;
    }

    @JsonProperty("quoteAssetPrecision")
    public Integer getQuoteAssetPrecision() {
        return quoteAssetPrecision;
    }

    @JsonProperty("quoteAssetPrecision")
    public void setQuoteAssetPrecision(Integer quoteAssetPrecision) {
        this.quoteAssetPrecision = quoteAssetPrecision;
    }

    @JsonProperty("orderTypes")
    public List<String> getOrderTypes() {
        return orderTypes;
    }

    @JsonProperty("orderTypes")
    public void setOrderTypes(List<String> orderTypes) {
        this.orderTypes = orderTypes;
    }

    @JsonProperty("icebergAllowed")
    public Boolean getIcebergAllowed() {
        return icebergAllowed;
    }

    @JsonProperty("icebergAllowed")
    public void setIcebergAllowed(Boolean icebergAllowed) {
        this.icebergAllowed = icebergAllowed;
    }

    @JsonProperty("ocoAllowed")
    public Boolean getOcoAllowed() {
        return ocoAllowed;
    }

    @JsonProperty("ocoAllowed")
    public void setOcoAllowed(Boolean ocoAllowed) {
        this.ocoAllowed = ocoAllowed;
    }

    @JsonProperty("isSpotTradingAllowed")
    public Boolean getIsSpotTradingAllowed() {
        return isSpotTradingAllowed;
    }

    @JsonProperty("isSpotTradingAllowed")
    public void setIsSpotTradingAllowed(Boolean isSpotTradingAllowed) {
        this.isSpotTradingAllowed = isSpotTradingAllowed;
    }

    @JsonProperty("isMarginTradingAllowed")
    public Boolean getIsMarginTradingAllowed() {
        return isMarginTradingAllowed;
    }

    @JsonProperty("isMarginTradingAllowed")
    public void setIsMarginTradingAllowed(Boolean isMarginTradingAllowed) {
        this.isMarginTradingAllowed = isMarginTradingAllowed;
    }

    @JsonProperty("filters")
    public List<BinanceSymbolDto> getFilters() {
        return filters;
    }

    @JsonProperty("filters")
    public void setFilters(List<BinanceSymbolDto> filters) {
        this.filters = filters;
    }

    @JsonProperty("permissions")
    public List<String> getPermissions() {
        return permissions;
    }

    @JsonProperty("permissions")
    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
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
        return "BinanceSymbolDto{" +
                "symbol='" + symbol + '\'' +
                ", status='" + status + '\'' +
                ", baseAsset='" + baseAsset + '\'' +
                ", baseAssetPrecision=" + baseAssetPrecision +
                ", quoteAsset='" + quoteAsset + '\'' +
                ", quotePrecision=" + quotePrecision +
                ", quoteAssetPrecision=" + quoteAssetPrecision +
                ", orderTypes=" + orderTypes +
                ", icebergAllowed=" + icebergAllowed +
                ", ocoAllowed=" + ocoAllowed +
                ", isSpotTradingAllowed=" + isSpotTradingAllowed +
                ", isMarginTradingAllowed=" + isMarginTradingAllowed +
                ", filters=" + filters +
                ", permissions=" + permissions +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}