package com.ytw.arbione.api.integration.okex.dto.currencies;

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
        "code",
        "msg",
        "data"
})
@Generated("jsonschema2pojo")
public class OkexCurrenciesDto {

    @JsonProperty("code")
    private String code;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("data")
    private List<OkexCurrenciesDatumDto> data = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("msg")
    public String getMsg() {
        return msg;
    }

    @JsonProperty("msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @JsonProperty("data")
    public List<OkexCurrenciesDatumDto> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<OkexCurrenciesDatumDto> data) {
        this.data = data;
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
        return "OkexCurrenciesPOJO{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}