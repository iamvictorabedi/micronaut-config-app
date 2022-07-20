package com.example.service.dto;

import com.example.domain.Metadata;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ConfigRequestDto {
    public String name;
    public Metadata metadata;

    public ConfigRequestDto() {
    }
}
