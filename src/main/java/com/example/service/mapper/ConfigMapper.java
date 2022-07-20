package com.example.service.mapper;

import com.example.domain.Config;
import com.example.service.dto.ConfigResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;
import java.util.Map;

/**
 * This use mapstruct to convert our dto to entity class and vice versa
 * its make the code much clean.
 * With mapstruct this conventions happens at runtime hence
 * @see ConfigMapperImpl will be generated automatically
 */
@Mapper
public interface ConfigMapper {
    List<ConfigResponseDto> toConfigResponse(final Iterable<Config> config);

    @Mapping(target = "name", source = "name")
    Config toConfigEntity(String name);
}
