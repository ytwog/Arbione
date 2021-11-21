package com.ytw.arbione.api.config;

import org.springframework.data.repository.CrudRepository;

public interface ConfigRepository extends CrudRepository<ArbiConfig, Integer> {
    ArbiConfig findByName(String name);
}
