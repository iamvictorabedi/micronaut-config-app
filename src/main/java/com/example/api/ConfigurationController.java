package com.example.api;


import com.example.service.ConfigService;
import com.example.service.dto.ConfigRequestDto;
import com.example.service.dto.ConfigResponseDto;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Slf4j
@Controller(value = "configs", produces = MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class ConfigurationController {

    private final ConfigService service;

    @Get(uri = "{name}")
    public List<ConfigResponseDto> getConfig(@PathVariable final String name) {
        log.debug("Request initiated to get a list of existing configurations");
        return service.getConfigByName(name);
    }

    @Get
    public List<ConfigResponseDto> getConfigurations() {
        log.debug("Request initiated to get a list of existing configurations");
        return service.getConfigurations();
    }

    @Post
    public List<ConfigResponseDto> createConfig(@Body final ConfigRequestDto configRequestDto) {
        log.debug("Request to process config: {} ", configRequestDto.toString());
        return service.createConfig(configRequestDto);
    }

    @Put(uri = "{name}")
    public List<ConfigResponseDto> updateConfiguration(@PathVariable final String name,
                                                       @Body final ConfigRequestDto configRequestDto) {
        log.debug("Request to update config: {} has being received", name);
        return service.updateConfig(name, configRequestDto);
    }

    @Delete(uri = "{name}")
    public HttpStatus removeConfiguration(@PathVariable final String name) {
        log.debug("Request to delete config: {} has being received", name);
        service.removeConfig(name);
        return HttpStatus.ACCEPTED;
    }
}
