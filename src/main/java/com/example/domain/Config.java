package com.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Entity class that contains Configurations properties.
 * This class cant be accessed directly by the service layer or controller layer
 * hence we use dtos to translate request to and fro to the entity class
 * @see com.example.service.dto.ConfigRequestDto and
 * @see com.example.service.dto.ConfigResponseDto
 */
@Entity
@Getter
@ToString
@Setter
@NoArgsConstructor
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "name", unique = true)
    private String name;

    public void update(final Config configUpdate) {
        this.name = configUpdate.name;
    }
}
