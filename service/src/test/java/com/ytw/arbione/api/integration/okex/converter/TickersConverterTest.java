package com.ytw.arbione.api.integration.okex.converter;

import com.ytw.arbione.api.integration.model.Message;
import com.ytw.arbione.api.integration.model.Tickers;
import com.ytw.arbione.api.integration.okex.dto.tickers.OkexTickersDatumDto;
import com.ytw.arbione.api.integration.okex.dto.tickers.OkexTickersDto;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TickersConverterTest {
    @Test
    public void convertCorrectly() throws Exception {
        // Creating sample object for convertion
        OkexTickersDatumDto datum = new OkexTickersDatumDto();
        datum.setInstId("some ID");
        datum.setAskPx("random data");
        OkexTickersDatumDto datum2 = new OkexTickersDatumDto();
        datum.setInstId("some ID 2");
        datum.setAskPx("random data");
        OkexTickersDto tickers = new OkexTickersDto();
        tickers.setData(Arrays.asList(datum, datum2));

        // Converting
        Message<Tickers> message = new TickersConverter().convert(tickers);

        assertEquals(message.getData().get(0).getInstId(), datum.getInstId());
        assertEquals(message.getData().get(1).getInstId(), datum2.getInstId());

        System.out.println(message);
    }
}