package com.ytw.arbione.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonManager {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static<T> String convert(T okexTickersDatumDto) throws JsonProcessingException {
        return objectMapper.writeValueAsString(okexTickersDatumDto);
    }
}
