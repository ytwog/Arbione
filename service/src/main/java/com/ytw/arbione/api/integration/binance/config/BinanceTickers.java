package com.ytw.arbione.api.integration.binance.config;

import com.ytw.arbione.api.config.MarketTickers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "binance_tickers")
public class BinanceTickers extends MarketTickers {
    @Column
    private String name;

    @Column
    private Boolean active;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Boolean getActive() {
        return active;
    }

    @Override
    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "BinanceTickers{" +
                "name='" + name + '\'' +
                ", active=" + active +
                "} " + super.toString();
    }
}
