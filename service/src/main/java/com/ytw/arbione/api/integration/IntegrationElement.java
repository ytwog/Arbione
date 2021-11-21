package com.ytw.arbione.api.integration;

import com.ytw.arbione.api.integration.enums.InstrumentType;
import com.ytw.arbione.api.integration.exception.IntegrationException;
import com.ytw.arbione.api.integration.model.Book;
import com.ytw.arbione.api.integration.model.MarketData;
import com.ytw.arbione.api.integration.model.Message;
import com.ytw.arbione.api.integration.model.Tickers;
import com.ytw.arbione.api.integration.okex.dto.book.OkexBookDto;
import com.ytw.arbione.api.integration.okex.dto.currencies.OkexCurrenciesDto;
import com.ytw.arbione.api.integration.okex.dto.index.OkexIndexTickersDto;

/**
 * Элемент интеграции с сервисами
 */
public interface IntegrationElement {
    OkexCurrenciesDto getCurrencies() throws IntegrationException;

    Message<Tickers> getTickers(InstrumentType instType, String uly) throws IntegrationException;

    Message<Book> getBook(String instId, String sz) throws IntegrationException;

    OkexIndexTickersDto getIndexes() throws IntegrationException;

    String getName();

    void fillBooks(MarketData marketData, int sz);
}
