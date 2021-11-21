package com.ytw.arbione.api.integration.okex.config;

import com.ytw.arbione.api.MarketTickersRepository;
import com.ytw.arbione.api.integration.okex.annotation.Okex;
import org.springframework.stereotype.Repository;

@Okex
@Repository
public interface OkexTickersRepository extends MarketTickersRepository<OkexTickers> {
}
