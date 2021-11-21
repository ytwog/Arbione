package com.ytw.arbione.api.integration.okex.config;

import com.ytw.arbione.api.config.MarketTickers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "okex_tickers")
public class OkexTickers extends MarketTickers {

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
        return "OkexTickers{" +
                "name='" + name + '\'' +
                ", active=" + active +
                "} " + super.toString();
    }
}
