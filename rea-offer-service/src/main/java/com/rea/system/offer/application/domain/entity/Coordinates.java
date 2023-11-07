package com.rea.system.offer.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class Coordinates {

    private String latitude;
    private String longitude;

}
