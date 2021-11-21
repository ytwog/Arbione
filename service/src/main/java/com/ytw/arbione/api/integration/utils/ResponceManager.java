package com.ytw.arbione.api.integration.utils;

import com.ytw.arbione.api.integration.exception.IntegrationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Работает с ответами от сервисов
 */
public class ResponceManager {
    public static final Logger logger = LoggerFactory.getLogger(ResponceManager.class);

    public static Object getBody(Call call) throws IntegrationException {
        try {
            Response response = call.execute();
            if(response.isSuccessful()) {
                return response.body();
            } else {
                throw new IntegrationException(String.format("error getting data from the service. Error description: %s", response.errorBody().string()));
            }
        } catch (IOException e) {
            throw new IntegrationException("error getting data from okex service", e);
        }
    }
}
