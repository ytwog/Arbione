package com.ytw.arbione.api.analisys;

import com.ytw.arbione.api.enums.Operation;
import com.ytw.arbione.api.integration.model.Book;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AnalisysHelperTest {

    @Test
    void calcTransferTest() {
        Book bookAbob = new Book(Lists.emptyList(), Arrays.asList(
            Arrays.asList("1", "2"),
            Arrays.asList("2", "2.5"),
            Arrays.asList("2.5", "1.5")
        ));
        Assert.assertEquals(5.7, AnalisysHelper.calcTransfer(Operation.BUY, 10, bookAbob), 0);
    }
}