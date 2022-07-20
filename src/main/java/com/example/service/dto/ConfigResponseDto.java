package com.example.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class ConfigResponseDto {
    private final Long id;
    private final String name;
}
