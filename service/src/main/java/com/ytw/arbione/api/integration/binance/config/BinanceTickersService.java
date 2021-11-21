package com.ytw.arbione.api.integration.binance.config;

import com.ytw.arbione.api.MarketTickersRepository;
import com.ytw.arbione.api.config.ConfigRepository;
import com.ytw.arbione.api.config.ConfigService;
import com.ytw.arbione.api.integration.IntegrationElement;
import com.ytw.arbione.api.integration.IntegrationManager;
import com.ytw.arbione.api.integration.binance.annotation.Binance;
import com.ytw.arbione.api.integration.enums.InstrumentType;
import com.ytw.arbione.api.integration.enums.Market;
import com.ytw.arbione.api.integration.exception.IntegrationException;
import com.ytw.arbione.api.integration.model.Tickers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinanceTickersService {
    private BinanceTickersRepository binanceTickersRepository;
    private IntegrationManager integrationManager;

    @Autowired
    public BinanceTickersService(@Binance MarketTickersRepository<BinanceTickers> binanceTickersRepository,
                                 IntegrationManager integrationManager) {
        this.binanceTickersRepository = (BinanceTickersRepository) binanceTickersRepository;
        this.integrationManager = integrationManager;
    }

    public BinanceTickers getByName(String name) {
        return binanceTickersRepository.findByName(name);
    }

    public Iterable<BinanceTickers> findAll() {
        return binanceTickersRepository.findAll();
    }

    public BinanceTickers save(BinanceTickers binanceTickers) {
        BinanceTickers res = binanceTickersRepository.findByName(binanceTickers.getName());
        return res == null ? binanceTickersRepository.save(binanceTickers) : res;
    }

    public void loadData(int activeTickersCount) throws IntegrationException {
        IntegrationElement controller = integrationManager.getElement(Market.BINANCE);

        int activeLeft = activeTickersCount;
        List<Tickers> allTickers = controller.getTickers(InstrumentType.SPOT, null).getData();

        for (Tickers tickers : allTickers) {
            BinanceTickers tickersToSave = new BinanceTickers();
            tickersToSave.setActive(activeLeft > 0);
            tickersToSave.setName(tickers.getInstId());
            save(tickersToSave);
            activeLeft--;
        }
    }
}
