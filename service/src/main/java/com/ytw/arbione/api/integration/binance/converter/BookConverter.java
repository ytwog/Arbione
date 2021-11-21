package com.ytw.arbione.api.integration.binance.converter;

import com.ytw.arbione.api.integration.binance.dto.book.BinanceBookDto;
import com.ytw.arbione.api.integration.model.Book;
import com.ytw.arbione.api.integration.model.Message;
import org.springframework.core.convert.converter.Converter;

import java.util.Collections;

public class BookConverter implements Converter<BinanceBookDto, Message<Book>> {
    @Override
    public Message<Book> convert(BinanceBookDto source) {
        Message<Book> message = new Message<>();
        Book tickersData = new Book(source.getAsks(), source.getBids());
        message.setData(Collections.singletonList(tickersData));
        return message;
    }
}
