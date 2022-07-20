package com.example.service;

import com.example.service.dto.ConfigRequestDto;
import com.example.service.dto.ConfigResponseDto;

import java.util.List;

public interface ConfigService {
    /**
     * Get all existing configurations
     * @return configurations
     */
    List<ConfigResponseDto> getConfigurations();

    /**
     * Create a new configuration
     * @return the new configuration
     */
    List<ConfigResponseDto> createConfig(final ConfigRequestDto configRequestDto);

    /**
     * update a existing configuration
     * @param configRequestDto new config data
     * @param name name of config
     * @return the updated configuration
     */
    List<ConfigResponseDto> updateConfig(final String name, final ConfigRequestDto configRequestDto);

    /**
     * Removes existing config by name
     * @param name name of config
     */
    void removeConfig(String name);

    /**
     * Get existing config by name
     * @param name name of config
     * @return ConfigResponseDto
     */
    List<ConfigResponseDto> getConfigByName(final String name);

}
