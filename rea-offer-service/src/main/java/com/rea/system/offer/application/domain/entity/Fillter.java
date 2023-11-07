package com.rea.system.offer.application.domain.entity;

import lombok.Builder;
import lombok.Getter;
import rea.system.common.model.EstateServiceType;

import java.util.Set;

@Getter
@Builder
public class Fillter {

    private EstateServiceType service;
    private Integer priceFrom;
    private Integer priceTo;
    private Double metersFrom;
    private Double metersTo;
    private Set<String> offerIds;

}
