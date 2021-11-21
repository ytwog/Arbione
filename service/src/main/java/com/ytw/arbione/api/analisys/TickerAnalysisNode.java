package com.ytw.arbione.api.analisys;

import com.ytw.arbione.api.integration.enums.Market;

public class TickerAnalysisNode {
    private Market tradeLocation;
    private String baseAsset;
    private String quoteAsset;
    private String instId;

    public TickerAnalysisNode() {
    }

    public Market getTradeLocation() {
        return tradeLocation;
    }

    public void setTradeLocation(Market tradeLocation) {
        this.tradeLocation = tradeLocation;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    @Override
    public String toString() {
        return "TickerAnalysisNode{" +
                "tradeLocation=" + tradeLocation +
                ", baseAsset='" + baseAsset + '\'' +
                ", quoteAsset='" + quoteAsset + '\'' +
                ", instId='" + instId + '\'' +
                '}';
    }
}
