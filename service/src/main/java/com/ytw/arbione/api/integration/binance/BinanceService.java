package com.ytw.arbione.api.integration.binance;

import com.ytw.arbione.api.integration.binance.dto.book.BinanceBookDto;
import com.ytw.arbione.api.integration.binance.dto.tickers.BinanceTickersDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface BinanceService {
    @GET("/api/v3/exchangeInfo")
    Call<BinanceTickersDto> getTickers(
        @Header("content-type") String contentType
    );

    @GET("/api/v3/depth")
    Call<BinanceBookDto> getBook(
        @Header("content-type") String contentType,
        @Query("symbol") String symbol,
        @Query("limit") int limit
    );
}
