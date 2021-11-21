package com.ytw.arbione.api.config.repository;

import com.ytw.arbione.api.config.ConfigService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConfigRepositoryTest {

    private final ConfigService configService;

    @Autowired
    public ConfigRepositoryTest(ConfigService configService) {
        this.configService = configService;
    }

    @Test
    public void configRepositoryTest() {
        System.out.println(configService.getValueByName("VERSION"));
    }
}