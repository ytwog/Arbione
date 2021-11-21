package com.ytw.arbione.api.config;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class MarketTickers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    abstract public String getName();

    abstract public void setName(String name);

    abstract public Boolean getActive();

    abstract public void setActive(Boolean active);

    @Override
    public String toString() {
        return "MarketTickers{" +
                "id=" + id +
                '}';
    }
}
