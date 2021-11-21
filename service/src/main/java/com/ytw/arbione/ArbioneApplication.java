package com.ytw.arbione;

import com.ytw.arbione.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArbioneApplication {

    private final ConfigService configService;

    @Autowired
    public ArbioneApplication(ConfigService configService) {
        this.configService = configService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ArbioneApplication.class, args);
    }

}
