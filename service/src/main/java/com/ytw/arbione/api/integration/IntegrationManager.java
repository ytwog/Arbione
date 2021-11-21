package com.ytw.arbione.api.integration;

import com.ytw.arbione.api.integration.binance.BinanceElement;
import com.ytw.arbione.api.integration.enums.Market;
import com.ytw.arbione.api.integration.exception.IntegrationException;
import com.ytw.arbione.api.integration.model.MarketData;
import com.ytw.arbione.api.integration.okex.OkexElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Генерирует контроллеры для API-сервисов, управляет их состоянием
 */
@Component
public class IntegrationManager {
    private static final Logger logger = LoggerFactory.getLogger(IntegrationManager.class);
    private Map<Market, IntegrationElement> elements;
    private Map<Market, MarketData> marketDatas;
    private ConfigManager configManager;

    @Autowired
    public IntegrationManager(ConfigManager configManager) {
        this.configManager = configManager;

        elements = new HashMap<>();
        elements.put(Market.OKEX, new OkexElement());
        elements.put(Market.BINANCE, new BinanceElement());

        marketDatas = new HashMap<>();
        marketDatas.put(Market.OKEX, new MarketData());
        marketDatas.put(Market.BINANCE, new MarketData());
    }

    public List<IntegrationElement> getElements() {
        return new ArrayList<>(elements.values());
    }

    public IntegrationElement getElement(Market market) throws IntegrationException {
        try {
            return elements.get(market);
        } catch (Exception e) {
            logger.error("Failed to find chosen IntegrationElement for chosen market", e);
            throw new IntegrationException("Failed to find chosen IntegrationElement for chosen market", e);
        }
    }

    public void setupMarkets(int tickersLimit) throws IntegrationException {
        for (Market activeMarket : configManager.getActiveMarkets()) {
            fillTickers(activeMarket, tickersLimit);
        }
    }

    public void updateBooksAll(int bookDepth) throws IntegrationException {
        for (Market activeMarket : configManager.getActiveMarkets()) {
            fillBooks(activeMarket, bookDepth);
        }
    }

    public List<MarketData> getMarketDatas() {
        return new ArrayList<>(marketDatas.values());
    }

    public MarketData getMarketData(Market market) throws IntegrationException {
        try {
            return marketDatas.get(market);
        } catch (Exception e) {
            logger.error("Failed to find chosen MarketData for chosen market", e);
            throw new IntegrationException("Failed to find chosen MarketData for chosen market", e);
        }
    }

    public void fillBooks(Market market, int sz) throws IntegrationException {
        getElement(market).fillBooks(marketDatas.get(market), sz);
    }

    public void fillTickers(Market market, int limit) throws IntegrationException {
        configManager.loadTickersNames(market, marketDatas.get(market), limit);
    }
}
