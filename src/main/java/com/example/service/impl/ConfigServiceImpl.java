package com.example.service.impl;

import com.example.domain.Config;
import com.example.repository.ConfigRepository;
import com.example.service.ConfigService;
import com.example.service.dto.ConfigRequestDto;
import com.example.service.dto.ConfigResponseDto;
import com.example.service.mapper.ConfigMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;

/**
 * @implNote This service class contains all business logic (crud) operations
 * to various configuration properties
 */
@Singleton
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ConfigServiceImpl implements ConfigService {

    private final ConfigRepository repository;
    private final ConfigMapper mapper;
    private final ObjectMapper objectMapper;

    @Override
    public List<ConfigResponseDto> getConfigurations() {
        return mapper.toConfigResponse(repository.findAll());
    }

    @Override
    public List<ConfigResponseDto> createConfig(ConfigRequestDto configRequestDto) {
        final Config newConfig = mapper.toConfigEntity(configRequestDto.getName());
        repository.save(newConfig);
        return mapper.toConfigResponse(singletonList(newConfig)) ;    }

    @Override
    public List<ConfigResponseDto> updateConfig(String name, ConfigRequestDto configRequestDto) {
        final Config existingConfig = repository.findByName(name);
        existingConfig.update(mapper.toConfigEntity(configRequestDto.getName()));
        repository.save(existingConfig);
        return mapper.toConfigResponse(singletonList(existingConfig));    }


    @Override
    public List<ConfigResponseDto> getConfigByName(final String name) {
        return mapper.toConfigResponse(singletonList(repository.findByName(name)));
    }


    @Override
    public void removeConfig(String name) {
        repository.deleteByName(name);
    }
}
