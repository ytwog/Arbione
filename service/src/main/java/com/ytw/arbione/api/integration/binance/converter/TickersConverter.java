package com.ytw.arbione.api.integration.binance.converter;

import org.springframework.core.convert.converter.Converter;
import com.ytw.arbione.api.integration.binance.dto.tickers.BinanceTickersDto;
import com.ytw.arbione.api.integration.model.Message;
import com.ytw.arbione.api.integration.model.Tickers;

import java.util.List;
import java.util.stream.Collectors;

public class TickersConverter implements Converter<BinanceTickersDto, Message<Tickers>> {
    @Override
    public Message<Tickers> convert(BinanceTickersDto source) {
        Message<Tickers> message = new Message<>();
        List<Tickers> tickersData = source.getSymbols().stream()
                .map(q -> new Tickers.Builder(q.getBaseAsset() + "-" + q.getQuoteAsset())
                        .build())
                .collect(Collectors.toList());
        message.setData(tickersData);
        return message;
    }
}
