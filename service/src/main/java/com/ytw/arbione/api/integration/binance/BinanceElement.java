package com.ytw.arbione.api.integration.binance;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ytw.arbione.api.analisys.TickerAnalysisNode;
import com.ytw.arbione.api.integration.IntegrationElement;
import com.ytw.arbione.api.integration.RetrofitClient;
import com.ytw.arbione.api.integration.binance.converter.BookConverter;
import com.ytw.arbione.api.integration.binance.dto.book.BinanceBookDto;
import com.ytw.arbione.api.integration.binance.dto.tickers.BinanceTickersDto;
import com.ytw.arbione.api.integration.enums.InstrumentType;
import com.ytw.arbione.api.integration.exception.IntegrationException;
import com.ytw.arbione.api.integration.model.Book;
import com.ytw.arbione.api.integration.model.MarketData;
import com.ytw.arbione.api.integration.model.Message;
import com.ytw.arbione.api.integration.binance.converter.TickersConverter;
import com.ytw.arbione.api.integration.model.Tickers;
import com.ytw.arbione.api.integration.okex.dto.book.OkexBookDto;
import com.ytw.arbione.api.integration.okex.dto.currencies.OkexCurrenciesDto;
import com.ytw.arbione.api.integration.okex.dto.index.OkexIndexTickersDto;
import com.ytw.arbione.api.integration.utils.ResponceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class BinanceElement implements IntegrationElement {
    public static final Logger logger = LoggerFactory.getLogger(BinanceElement.class);
    private final static String URL = "https://api1.binance.com";
    private final static Class serviceClass = BinanceService.class;
    private static String API_KEY;
    private static String SECRET_KEY;
    private final static String CONTENT_TYPE = "application/json; charset=utf8";
    private static final String MARKET_NAME = "BINANCE";

    private RetrofitClient client;
    private ObjectMapper mapper;
    private TickersConverter tickersConverter;
    private BookConverter bookConverter;

    public BinanceElement() {
        client = new RetrofitClient(URL, serviceClass);
        mapper = new ObjectMapper();
        tickersConverter = new TickersConverter();
        bookConverter = new BookConverter();
    }

    @Override
    public Message<Tickers> getTickers(InstrumentType instType, String uly) throws IntegrationException {
        return tickersConverter.convert((BinanceTickersDto) ResponceManager.getBody(((BinanceService) client.getService()).getTickers(
            CONTENT_TYPE
        )));
    }


    @Override
    public OkexCurrenciesDto getCurrencies() throws IntegrationException {
        throw new NotImplementedException();
    }

    @Override
    public Message<Book> getBook(String instId, String sz) throws IntegrationException {
        return bookConverter.convert((BinanceBookDto) ResponceManager.getBody(((BinanceService) client.getService()).getBook(
            CONTENT_TYPE,
            instId.replace("-", ""),
            Integer.parseInt(sz)
        )));
    }

    @Override
    public OkexIndexTickersDto getIndexes() throws IntegrationException {
        throw new NotImplementedException();
    }

    @Override
    public void fillBooks(MarketData marketData, int sz) {
        List<TickerAnalysisNode> tickerNodes = marketData.getTickerNodes();
        for (TickerAnalysisNode tickerNode : tickerNodes) {
            String instId = tickerNode.getInstId();
            marketData.putBook(instId, getBook(instId, String.valueOf(sz)).getData().get(0));
        }
    }

    @Override
    public String getName() {
        return MARKET_NAME;
    }
}
