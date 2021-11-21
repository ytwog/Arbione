package com.ytw.arbione.api.integration;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private Object service;

    public RetrofitClient(String url, Class serviceClass) {
        service = initializeService(url, serviceClass);
    }

    /**
     * Создать сервис Retrofit
     * @param url адрес нужной API
     * @param serviceClass класс создаваемой API
     * @return
     */
    private Object initializeService(String url, Class serviceClass) {
         Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

    public Object getService() {
        return service;
    }
}
