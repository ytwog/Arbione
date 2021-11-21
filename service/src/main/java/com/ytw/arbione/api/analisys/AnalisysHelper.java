package com.ytw.arbione.api.analisys;

import com.ytw.arbione.api.enums.Operation;
import com.ytw.arbione.api.integration.enums.Market;
import com.ytw.arbione.api.integration.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AnalisysHelper {
    private static final Logger logger = LoggerFactory.getLogger(AnalisysHelper.class);
    public static TickerAnalysisNode fromTickerNameToNode(String tickerName, Market market) {
        TickerAnalysisNode res = new TickerAnalysisNode();
        res.setTradeLocation(market);
        res.setInstId(tickerName);
        res.setBaseAsset(tickerName.split("-")[0]);
        res.setQuoteAsset(tickerName.split("-")[1]);
        return res;
    }

    public static String fromAssetsToInst(String from, String to) {
        return from + to;
    }

    public static double calcTransfer(Operation operation, double transferingValue, Book endBook) {
        double receivedValue = 0;
        double transferingLeft = transferingValue;
        int bookIndex = 0;
        int bookDepth = endBook.getBids().size();
        List<List<String>> bookInfos = operation.equals(Operation.SELL) ?
                endBook.getBids() : endBook.getAsks();
        while(transferingLeft > 0 && bookIndex < bookDepth) {
            double price = Double.parseDouble(bookInfos.get(bookIndex).get(0));
            double size = Math.min(Double.parseDouble(bookInfos.get(bookIndex).get(1)),
                    transferingLeft / price);
            // Тратим валюту
            transferingLeft -= price * size;
            // Получаем другую валюту
            receivedValue += size;
            bookIndex++;
        }

        logger.info("transferingValue = {}, receivedValue = {}, bookInfos = {}", transferingValue, receivedValue, bookInfos);

        if(transferingLeft > 0) {
            throw new ArrayIndexOutOfBoundsException("Book depth is not able to fulfill desired transfer");
        }
        return receivedValue;
    }
}
