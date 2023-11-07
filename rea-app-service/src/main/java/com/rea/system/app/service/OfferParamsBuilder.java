package com.rea.system.app.service;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import rea.system.common.model.EstateServiceType;

import java.util.Optional;

class OfferParamsBuilder {

    private final EstateServiceType estateServiceType;
    private final String pageIndex;
    private final String pageSize;
    private final Integer priceFrom;
    private final Integer priceTo;
    private final Double metersFrom;
    private final Double metersTo;

    @Getter
    private final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

    @Builder
    private OfferParamsBuilder(EstateServiceType estateServiceType,
                               String pageIndex,
                               String pageSize,
                               Integer priceFrom,
                               Integer priceTo,
                               Double metersFrom,
                               Double metersTo) {
        this.estateServiceType = estateServiceType;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.metersFrom = metersFrom;
        this.metersTo = metersTo;
    }

    public OfferParamsBuilder buildParams() {
        params.add("estateServiceType", estateServiceType.toString());
        params.add("pageIndex", pageIndex);
        params.add("pageSize", pageSize);
        Optional.ofNullable(priceFrom).ifPresent(priceF -> params.add("priceFrom", priceF.toString()));
        Optional.ofNullable(priceTo).ifPresent(priceT -> params.add("priceTo", priceT.toString()));
        Optional.ofNullable(metersFrom).ifPresent(metersF -> params.add("metersFrom", metersF.toString()));
        Optional.ofNullable(metersTo).ifPresent(metersT -> params.add("metersTo", metersT.toString()));
        return this;
    }

}
