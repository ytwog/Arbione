
package com.ytw.arbione.api.integration.okex.dto.currencies;

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
        "ccy",
        "chain",
        "name",
        "canDep",
        "canWd",
        "canInternal",
        "minWd",
        "maxFee",
        "minFee"
})
@Generated("jsonschema2pojo")
public class OkexCurrenciesDatumDto {

    @JsonProperty("ccy")
    private String ccy;
    @JsonProperty("chain")
    private String chain;
    @JsonProperty("name")
    private String name;
    @JsonProperty("canDep")
    private Boolean canDep;
    @JsonProperty("canWd")
    private Boolean canWd;
    @JsonProperty("canInternal")
    private Boolean canInternal;
    @JsonProperty("minWd")
    private String minWd;
    @JsonProperty("maxFee")
    private String maxFee;
    @JsonProperty("minFee")
    private String minFee;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ccy")
    public String getCcy() {
        return ccy;
    }

    @JsonProperty("ccy")
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @JsonProperty("chain")
    public String getChain() {
        return chain;
    }

    @JsonProperty("chain")
    public void setChain(String chain) {
        this.chain = chain;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("canDep")
    public Boolean getCanDep() {
        return canDep;
    }

    @JsonProperty("canDep")
    public void setCanDep(Boolean canDep) {
        this.canDep = canDep;
    }

    @JsonProperty("canWd")
    public Boolean getCanWd() {
        return canWd;
    }

    @JsonProperty("canWd")
    public void setCanWd(Boolean canWd) {
        this.canWd = canWd;
    }

    @JsonProperty("canInternal")
    public Boolean getCanInternal() {
        return canInternal;
    }

    @JsonProperty("canInternal")
    public void setCanInternal(Boolean canInternal) {
        this.canInternal = canInternal;
    }

    @JsonProperty("minWd")
    public String getMinWd() {
        return minWd;
    }

    @JsonProperty("minWd")
    public void setMinWd(String minWd) {
        this.minWd = minWd;
    }

    @JsonProperty("maxFee")
    public String getMaxFee() {
        return maxFee;
    }

    @JsonProperty("maxFee")
    public void setMaxFee(String maxFee) {
        this.maxFee = maxFee;
    }

    @JsonProperty("minFee")
    public String getMinFee() {
        return minFee;
    }

    @JsonProperty("minFee")
    public void setMinFee(String minFee) {
        this.minFee = minFee;
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
        return "OkexDatum{" +
                "ccy='" + ccy + '\'' +
                ", chain='" + chain + '\'' +
                ", name='" + name + '\'' +
                ", canDep=" + canDep +
                ", canWd=" + canWd +
                ", canInternal=" + canInternal +
                ", minWd='" + minWd + '\'' +
                ", maxFee='" + maxFee + '\'' +
                ", minFee='" + minFee + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}