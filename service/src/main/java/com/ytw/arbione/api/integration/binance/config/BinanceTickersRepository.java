package com.ytw.arbione.api.integration.binance.config;

import com.ytw.arbione.api.MarketTickersRepository;
import com.ytw.arbione.api.integration.binance.annotation.Binance;
import org.springframework.stereotype.Repository;

@Binance
@Repository
public interface BinanceTickersRepository extends MarketTickersRepository<BinanceTickers> {

}
