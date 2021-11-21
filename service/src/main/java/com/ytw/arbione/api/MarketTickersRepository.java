package com.ytw.arbione.api;

import com.ytw.arbione.api.config.MarketTickers;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface MarketTickersRepository<T extends MarketTickers> extends CrudRepository<T, Integer> {
    T findByName(String name);

    List<T> findByActive(boolean active);
    List<T> findTopByActive(boolean active, Pageable pageable);
}
