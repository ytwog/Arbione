package com.ytw.arbione.api.analisys;

import com.ytw.arbione.api.analisys.exception.OverlordException;
import com.ytw.arbione.api.config.StringParameters;
import com.ytw.arbione.api.enums.Operation;
import com.ytw.arbione.api.integration.ConfigManager;
import com.ytw.arbione.api.integration.IntegrationElement;
import com.ytw.arbione.api.integration.IntegrationManager;
import com.ytw.arbione.api.integration.enums.Market;
import com.ytw.arbione.api.integration.model.MarketData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class OverlordService {
    private static final Logger logger = LoggerFactory.getLogger(OverlordService.class);
    private List<TickerAnalysisNode> tickerNodes;
    private ConfigManager configManager;
    private IntegrationManager integrationManager;
    private DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private int bookDepthValue;
    private int symbolsPerMarketValue;
    private DecimalFormat df;

    @Autowired
    public OverlordService(ConfigManager configManager, IntegrationManager integrationManager) {
        this.configManager = configManager;
        this.integrationManager = integrationManager;

        bookDepthValue = Integer.parseInt(configManager.getConfigParameter(StringParameters.BOOK_DEPTH));
        symbolsPerMarketValue = Integer.parseInt(configManager.getConfigParameter(StringParameters.SYMBOLS_PER_MARKET));

        integrationManager.setupMarkets(symbolsPerMarketValue);

        df = new DecimalFormat("0");
        df.setMaximumFractionDigits(340);

        logger.info("OverlordService loaded at: {}", dateFormat.format(LocalDateTime.now()));
    }

    public void findProfitRoute(Market startMarket) throws OverlordException {
        IntegrationElement startElement = integrationManager.getElement(startMarket);

        integrationManager.updateBooksAll(bookDepthValue);
        MarketData marketData = integrationManager.getMarketData(startMarket);
        MarketData endMarketData = integrationManager.getMarketData(Market.BINANCE);

        List<TickerAnalysisNode> startAssets = marketData.getTickerNodes();
        List<TickerAnalysisNode> endAssets = endMarketData.getTickerNodes();

        double maxProfit = 0;
        for (TickerAnalysisNode startAsset : startAssets) {
            maxProfit = Math.max(maxProfit, endAssets.stream()
                    .filter(
                        asset -> asset.getBaseAsset().equals(startAsset.getQuoteAsset()
                    ))
                    .map(asset -> testRoute(0.0001, startAsset, asset))
                    .max(Double::compareTo)
                    .orElse(0.0));
        }
    }

    public double testRoute(double valueAmount, TickerAnalysisNode ...assetSteps) {
        double resultValue;

        logger.info(Arrays.toString(assetSteps));

        logger.info("Test new route...");

        // Перевод валюты на 1 рынке
        resultValue = testMove(Operation.BUY, assetSteps[0].getTradeLocation(), assetSteps[0].getInstId(), valueAmount);

        logger.info("<{}>.{} => <{}>.{}({})",
                assetSteps[0].getTradeLocation(), assetSteps[0].getBaseAsset(),
                assetSteps[0].getTradeLocation(), assetSteps[0].getQuoteAsset(), df.format(resultValue)
        );

        /* TODO Учет комиссии - Перевод на другой рынок */

        // Перевод валюты на 2 рынкеokex_tickers
        resultValue = testMove(Operation.BUY, assetSteps[1].getTradeLocation(), assetSteps[1].getInstId(), resultValue);

        logger.info("<{}>.{} => <{}>.{}({})",
                assetSteps[1].getTradeLocation(), assetSteps[1].getBaseAsset(),
                assetSteps[1].getTradeLocation(), assetSteps[1].getQuoteAsset(), df.format(resultValue)
        );

        /* TODO Учет комиссии - Перевод на другой рынок */

        // Перевод в исходную валюту на 1 рынке
        resultValue = testMove(Operation.SELL, assetSteps[0].getTradeLocation(), assetSteps[1].getInstId(), resultValue);

        logger.info("<{}>.{} => <{}>.{}({})",
                assetSteps[0].getTradeLocation(), assetSteps[1].getQuoteAsset(),
                assetSteps[0].getTradeLocation(), assetSteps[1].getBaseAsset(), resultValue
        );

        logger.info("Test summary: {} => {}", df.format(valueAmount), df.format(resultValue));
        logger.info("---------------------");
        return resultValue;
    }

    private double testMove(Operation operation, Market tradeLocation, String instId, double transferingValue) {
        return AnalisysHelper.calcTransfer(
                operation,
                transferingValue,
                integrationManager.getMarketData(tradeLocation).getBook(instId)
        );
    }
}
