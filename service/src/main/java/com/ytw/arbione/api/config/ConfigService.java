package com.ytw.arbione.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConfigService {
    private static final Logger logger = LoggerFactory.getLogger(ConfigService.class);
    private ConfigRepository configRepository;
    private Map<String, String> parameters;

    @Autowired
    public ConfigService(ConfigRepository configRepository) {
        this.configRepository = configRepository;
        parameters = loadParameters();
    }

    public Map<String, String> loadParameters() {
        Map<String, String> res = new HashMap<>();
        logger.info("Application config parameters:");
        for (ArbiConfig arbiConfig : configRepository.findAll()) {
            res.put(arbiConfig.getName(), arbiConfig.getValue());
            logger.info("{}: {}", arbiConfig.getName(), arbiConfig.getValue());
        }
        return res;
    }

    public String getValueByName(String name) {
        return parameters.getOrDefault(name, null);
    }
}
