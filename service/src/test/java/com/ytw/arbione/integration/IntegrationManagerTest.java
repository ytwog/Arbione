package com.ytw.arbione.integration;

import com.ytw.arbione.api.integration.ConfigManager;
import com.ytw.arbione.api.integration.IntegrationElement;
import com.ytw.arbione.api.integration.IntegrationManager;
import com.ytw.arbione.api.integration.enums.InstrumentType;
import com.ytw.arbione.api.integration.enums.Market;
import com.ytw.arbione.api.integration.exception.IntegrationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationManagerTest {
    private static final Market SPECIFIED_MARKET = null;

    //@Test
    public void integrationTestCurrencies() throws Exception {
        List<IntegrationElement> controllers = getDesiredElements();
        for (IntegrationElement controller : controllers) {
            System.out.println(controller.getCurrencies());
        }
    }

    @Test
    public void integrationTestTickers() throws Exception {
        List<IntegrationElement> controllers = getDesiredElements();
        for (IntegrationElement controller : controllers) {
            System.out.println(controller.getTickers(InstrumentType.SPOT, null));
        }
    }

    @Test
    public void integrationTestBooks() throws Exception {
        List<IntegrationElement> controllers = getDesiredElements();
        for (IntegrationElement controller : controllers) {
            System.out.println("Market: " + controller.getName());
            System.out.println(controller.getBook("BCD-BTC", "15"));
        }
    }

    private List<IntegrationElement> getDesiredElements() throws IntegrationException {
        IntegrationManager integrationManager = new IntegrationManager(Mockito.mock(ConfigManager.class));
        return SPECIFIED_MARKET == null ?
                integrationManager.getElements() :
                Arrays.asList(integrationManager.getElement(SPECIFIED_MARKET));
    }
}
