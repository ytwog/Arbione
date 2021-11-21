package com.ytw.arbione.api.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ytw.arbione.api.analisys.TickerAnalysisNode;
import com.ytw.arbione.api.config.StringParameters;
import com.ytw.arbione.api.integration.enums.InstrumentType;
import com.ytw.arbione.api.integration.enums.Market;
import com.ytw.arbione.api.integration.exception.IntegrationException;
import com.ytw.arbione.api.integration.model.Book;
import com.ytw.arbione.api.integration.model.Tickers;
import com.ytw.arbione.api.integration.okex.dto.book.OkexBookDatumDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/arbione/api/market")
public class IntegrationController {
    private static final Logger logger = LoggerFactory.getLogger(IntegrationController.class);
    private IntegrationManager integrationManager;
    private ConfigManager configManager;

    @Autowired
    public IntegrationController(IntegrationManager integrationManager, ConfigManager configManager) {
        this.integrationManager = integrationManager;
        this.configManager = configManager;

        int tickersLimit = Integer.parseInt(configManager.getConfigParameter(StringParameters.SYMBOLS_PER_MARKET));
        for (Market activeMarket : configManager.getActiveMarkets()) {
            integrationManager.fillTickers(activeMarket, tickersLimit);
        }
    }

    @GetMapping("{market}/books")
    @ResponseBody
    public List<Book> getTickers(@PathVariable String market, @RequestParam String instId,
                                 @RequestParam String sz)
            throws IntegrationException {
        IntegrationElement controller;
        try {
            controller = integrationManager.getElement(Market.valueOf(market));
        } catch (IllegalArgumentException e) {
            logger.error("Failed to map chosen market to program market list", e);
            throw new IntegrationException("Failed to map chosen market to program market list", e);
        }
        return controller.getBook(instId, sz).getData();
    }

    @GetMapping("{market}/tickers")
    @ResponseBody
    public List<String> getTickers(@PathVariable String market) throws IntegrationException {
        return integrationManager.getMarketData(Market.valueOf(market.toUpperCase())).getTickerNodes().stream()
                .map(TickerAnalysisNode::getInstId)
                .collect(Collectors.toList());
    }

    @GetMapping("{market}/tickers/ids")
    public List<String> getTickersIds(@PathVariable String market) throws IntegrationException {
        IntegrationElement controller;
        try {
            controller = integrationManager.getElement(Market.valueOf(market));
        } catch (IllegalArgumentException e) {
            logger.error("Failed to map chosen market to program market list", e);
            throw new IntegrationException("Failed to map chosen market to program market list", e);
        }
        return controller.getTickers(InstrumentType.SPOT, null).getData()
                .stream()
                .map(Tickers::getInstId)
                .collect(Collectors.toList());
    }
}
