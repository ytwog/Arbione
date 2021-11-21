package com.ytw.arbione.integration;

import com.ytw.arbione.api.integration.binance.config.BinanceTickersService;
import com.ytw.arbione.api.integration.okex.config.OkexTickers;
import com.ytw.arbione.api.integration.okex.config.OkexTickersService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IntegrationDatabaseTest {
    private static final Logger logger = LoggerFactory.getLogger(IntegrationDatabaseTest.class);
    private static final int ACTIVE_TICKERS_COUNT = 5;
    private final OkexTickersService okexTickersService;
    private final BinanceTickersService binanceTickersService;

    @Autowired
    public IntegrationDatabaseTest(OkexTickersService okexTickersService, BinanceTickersService binanceTickersService) {
        this.okexTickersService = okexTickersService;
        this.binanceTickersService = binanceTickersService;
    }

    @Test
    public void fillDatabaseTickers() throws Exception {
        logger.info("-- Loading OKEX tickers --");
        okexTickersService.loadData(ACTIVE_TICKERS_COUNT);
        logger.info("-- Loading BINANCE tickers --");
        binanceTickersService.loadData(ACTIVE_TICKERS_COUNT);
    }

    @Test
    public void getDatabaseTickers() throws Exception {
        for (OkexTickers okexTickers : okexTickersService.findAll()) {
            System.out.println(okexTickers);
        }
    }
}
