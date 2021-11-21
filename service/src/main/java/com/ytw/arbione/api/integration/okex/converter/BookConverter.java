package com.ytw.arbione.api.integration.okex.converter;

import com.ytw.arbione.api.integration.model.Book;
import com.ytw.arbione.api.integration.model.Message;
import com.ytw.arbione.api.integration.okex.dto.book.OkexBookDto;
import org.springframework.core.convert.converter.Converter;

import java.util.Collections;

public class BookConverter implements Converter<OkexBookDto, Message<Book>> {
    @Override
    public Message<Book> convert(OkexBookDto source) {
        Message<Book> message = new Message<>();
        Book tickersData = new Book(
            source.getData().get(0).getAsks(),
            source.getData().get(0).getBids()
        );
        message.setData(Collections.singletonList(tickersData));
        return message;
    }
}
