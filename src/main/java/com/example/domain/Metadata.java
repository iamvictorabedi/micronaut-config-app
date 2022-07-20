package com.example.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Contains Configuration metadata properties
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Metadata {
    Monitoring monitoring;
    Limit limits;

    public Metadata() {
    }
}
