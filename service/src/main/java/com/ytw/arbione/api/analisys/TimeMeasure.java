package com.ytw.arbione.api.analisys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeMeasure {
    private static final Logger logger = LoggerFactory.getLogger(TimeMeasure.class);
    private DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public void logCheckpoint(String action) {
        logger.info("{}: {}", action, dateFormat.format(LocalDateTime.now()));
    }
}
