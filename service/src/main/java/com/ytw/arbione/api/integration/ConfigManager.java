package com.ytw.arbione.api.integration;

import com.ytw.arbione.api.MarketTickersRepository;
import com.ytw.arbione.api.analisys.AnalisysHelper;
import com.ytw.arbione.api.analisys.TickerAnalysisNode;
import com.ytw.arbione.api.config.ConfigService;
import com.ytw.arbione.api.config.MarketTickers;
import com.ytw.arbione.api.config.StringParameters;
import com.ytw.arbione.api.integration.binance.annotation.Binance;
import com.ytw.arbione.api.integration.binance.config.BinanceTickers;
import com.ytw.arbione.api.integration.binance.config.BinanceTickersRepository;
import com.ytw.arbione.api.integration.enums.Market;
import com.ytw.arbione.api.integration.model.MarketData;
import com.ytw.arbione.api.integration.okex.annotation.Okex;
import com.ytw.arbione.api.integration.okex.config.OkexTickers;
import com.ytw.arbione.api.integration.okex.config.OkexTickersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ConfigManager {
    private static final Logger logger = LoggerFactory.getLogger(ConfigManager.class);
    private ConfigService configService;
    private Map<Market, MarketTickersRepository> repos;

    @Autowired
    public ConfigManager(@Binance MarketTickersRepository<BinanceTickers> binanceTickersRepository,
                         @Okex MarketTickersRepository<OkexTickers> okexTickersRepository,
                         ConfigService configService) {
        repos = new HashMap<>();
        repos.put(Market.BINANCE, binanceTickersRepository);
        repos.put(Market.OKEX, okexTickersRepository);

        this.configService = configService;
    }

    public void loadTickersNames(Market market, MarketData marketData, int symbolsPerMarket) {
        List<TickerAnalysisNode> res = new ArrayList<>();
        if(isActive(market)) {
            marketData.setTickerNodes(
                    (List<TickerAnalysisNode>)
                        (symbolsPerMarket == 0 ?
                        repos.get(market).findByActive(true) :
                        repos.get(market).findTopByActive(true, PageRequest.of(0, symbolsPerMarket)))
                            .stream()
                            .map(q -> AnalisysHelper.fromTickerNameToNode(((MarketTickers) q).getName(), market))
                        .collect(Collectors.toList()));
        } else {
            logger.info("Market ${} is not active", market);
        }
    }

    public List<Market> getActiveMarkets() {
        Set<Market> markets = repos.keySet();
        return markets.stream()
                .filter(this::isActive)
                .collect(Collectors.toList());
    }

    public boolean isActive(Market market) {
        return Boolean.parseBoolean(configService.getValueByName(market.name() + "_" + StringParameters.ACTIVE_POSTFIX));
    }

    public String getConfigParameter(String configName) {
        return configService.getValueByName(configName);
    }
}
