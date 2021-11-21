package com.ytw.arbione.api.integration.okex.config;

import com.ytw.arbione.api.MarketTickersRepository;
import com.ytw.arbione.api.integration.IntegrationElement;
import com.ytw.arbione.api.integration.IntegrationManager;
import com.ytw.arbione.api.integration.enums.InstrumentType;
import com.ytw.arbione.api.integration.enums.Market;
import com.ytw.arbione.api.integration.exception.IntegrationException;
import com.ytw.arbione.api.integration.model.Tickers;
import com.ytw.arbione.api.integration.okex.annotation.Okex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OkexTickersService {
    private OkexTickersRepository okexTickersRepository;
    private IntegrationManager integrationManager;

    @Autowired
    public OkexTickersService(@Okex MarketTickersRepository<OkexTickers> okexTickersRepository, IntegrationManager integrationManager) {
        this.okexTickersRepository = (OkexTickersRepository) okexTickersRepository;
        this.integrationManager = integrationManager;
    }

    public OkexTickers getByName(String name) {
        return okexTickersRepository.findByName(name);
    }

    public Iterable<OkexTickers> findAll() {
        return okexTickersRepository.findAll();
    }

    public OkexTickers save(OkexTickers okexTickers) {
        OkexTickers res = okexTickersRepository.findByName(okexTickers.getName());
        return res == null ? okexTickersRepository.save(okexTickers) : res;
    }

    public void loadData(int activeTickersCount) throws IntegrationException {
        IntegrationElement controller = integrationManager.getElement(Market.OKEX);

        int activeLeft = activeTickersCount;
        List<Tickers> allTickers = controller.getTickers(InstrumentType.SPOT, null).getData();

        for (Tickers tickers : allTickers) {
            OkexTickers tickersToSave = new OkexTickers();
            tickersToSave.setActive(activeLeft > 0);
            tickersToSave.setName(tickers.getInstId());
            save(tickersToSave);
            activeLeft--;
        }
    }
}
