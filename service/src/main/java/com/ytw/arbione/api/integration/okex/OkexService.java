package com.ytw.arbione.api.integration.okex;

import com.ytw.arbione.api.integration.okex.dto.book.OkexBookDto;
import com.ytw.arbione.api.integration.okex.dto.currencies.OkexCurrenciesDto;
import com.ytw.arbione.api.integration.okex.dto.index.OkexIndexTickersDto;
import com.ytw.arbione.api.integration.okex.dto.tickers.OkexTickersDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface OkexService {
    @GET("/api/v5/asset/currencies")
    Call<OkexCurrenciesDto> getCurrenciesData(
        @Header("content-type") String contentType,
        @Header("OK-ACCESS-KEY") String okAccessKey,
        @Header("OK-ACCESS-SIGN") String okAccessSign,
        @Header("OK-ACCESS-TIMESTAMP") String okAccessTimeStamp,
        @Header("OK-ACCESS-PASSPHRASE") String okAccessPassphrase
    );

    @GET("/api/v5/market/tickers")
    Call<OkexTickersDto> getTickers(
            @Header("content-type") String contentType,
            @Header("OK-ACCESS-KEY") String okAccessKey,
            @Header("OK-ACCESS-SIGN") String okAccessSign,
            @Header("OK-ACCESS-TIMESTAMP") String okAccessTimeStamp,
            @Header("OK-ACCESS-PASSPHRASE") String okAccessPassphrase,
            @Query("instType") String instType,
            @Query("uly") String uly
    );

    @GET("/api/v5/market/books")
    Call<OkexBookDto> getBook(
            @Header("content-type") String contentType,
            @Header("OK-ACCESS-KEY") String okAccessKey,
            @Header("OK-ACCESS-SIGN") String okAccessSign,
            @Header("OK-ACCESS-TIMESTAMP") String okAccessTimeStamp,
            @Header("OK-ACCESS-PASSPHRASE") String okAccessPassphrase,
            @Query("instId") String instId,
            @Query("sz") String sz
    );

    /* Не допилено (и не надо) */
    @Deprecated
    @GET("/api/v5/market/index-tickers")
    Call<OkexIndexTickersDto> getIndexTickers(
        @Header("content-type") String contentType,
        @Header("OK-ACCESS-KEY") String okAccessKey,
        @Header("OK-ACCESS-SIGN") String okAccessSign,
        @Header("OK-ACCESS-TIMESTAMP") String okAccessTimeStamp,
        @Header("OK-ACCESS-PASSPHRASE") String okAccessPassphrase
    );
}
