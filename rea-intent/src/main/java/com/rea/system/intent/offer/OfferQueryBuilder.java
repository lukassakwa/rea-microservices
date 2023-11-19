package com.rea.system.intent.offer;

import lombok.Builder;
import org.springframework.util.LinkedMultiValueMap;
import rea.system.common.model.offer.EstateServiceType;

import java.util.Optional;

@Builder
public class OfferQueryBuilder {

    private EstateServiceType estateServiceType;
    private Integer priceFrom;
    private Integer priceTo;
    private Double metersFrom;
    private Double metersTo;

    private final LinkedMultiValueMap<String, String> queryMap = new LinkedMultiValueMap<>();

    LinkedMultiValueMap<String, String> buildQueryParams() {
        Optional.ofNullable(estateServiceType).ifPresent(serviceType -> queryMap.add("estateServiceType", serviceType.name()));
        Optional.ofNullable(priceFrom).ifPresent(priceF -> queryMap.add("priceFrom", priceF.toString()));
        Optional.ofNullable(priceTo).ifPresent(priceT -> queryMap.add("priceTo", priceT.toString()));
        Optional.ofNullable(metersFrom).ifPresent(metersF -> queryMap.add("metersFrom", metersF.toString()));
        Optional.ofNullable(metersTo).ifPresent(metersT -> queryMap.add("metersTo", metersT.toString()));
        return queryMap;
    }


}
