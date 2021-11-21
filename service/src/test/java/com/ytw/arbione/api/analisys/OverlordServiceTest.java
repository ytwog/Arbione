package com.ytw.arbione.api.analisys;

import com.ytw.arbione.api.integration.enums.Market;
import com.ytw.arbione.api.integration.exception.IntegrationException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OverlordServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(OverlordServiceTest.class);
    private static final int REPEAT_NUMBER = 1;
    private OverlordService overlordService;
    private TimeMeasure timeMeasure;

    @Autowired
    public OverlordServiceTest(OverlordService overlordService) {
        this.overlordService = overlordService;
        timeMeasure = new TimeMeasure();
    }

    @Test
    public void serviceShouldReceiveBooks() throws Exception {
        for (int i = 0; i < REPEAT_NUMBER; i++) {
            overlordService.findProfitRoute(Market.OKEX);
            timeMeasure.logCheckpoint("findProfitRoute");
        }
    }
}