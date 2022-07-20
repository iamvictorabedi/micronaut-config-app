package com.example.repository;

import com.example.domain.Config;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;


@Repository
public interface ConfigRepository extends CrudRepository<Config, Long> {
    Config findByName(String name);

    void deleteByName(String name);

}
