package com.ytw.arbione.api.integration.okex.converter;

import com.ytw.arbione.api.integration.model.Message;
import com.ytw.arbione.api.integration.model.Tickers;
import com.ytw.arbione.api.integration.okex.dto.tickers.OkexTickersDto;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class TickersConverter implements Converter<OkexTickersDto, Message<Tickers>> {
    @Override
    public Message<Tickers> convert(OkexTickersDto source) {
        Message<Tickers> message = new Message<>();
        List<Tickers> tickersData = source.getData().stream()
                .map(q -> new Tickers.Builder(q.getInstId())
                        .build())
                .collect(Collectors.toList());
        message.setData(tickersData);
        return message;
    }
}
