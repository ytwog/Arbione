package com.ytw.arbione.api.integration.model;

import com.ytw.arbione.api.analisys.TickerAnalysisNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketData {
    private List<TickerAnalysisNode> tickerNodes;
    private final Map<String, Book> books = new HashMap<>();

    public List<TickerAnalysisNode> getTickerNodes() {
        return tickerNodes;
    }

    public void setTickerNodes(List<TickerAnalysisNode> tickerNodes) {
        this.tickerNodes = tickerNodes;
    }

    public Book getBook(String ticker) {
        return books.get(ticker);
    }

    public void putBook(String ticker, Book book) {
        books.put(ticker, book);
    }

    @Override
    public String toString() {
        return "MarketData{" +
                "tickerNodes=" + tickerNodes +
                ", books=" + books +
                '}';
    }
}