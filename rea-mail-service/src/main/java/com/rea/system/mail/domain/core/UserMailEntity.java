package com.rea.system.mail.domain.core;

import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;
import rea.system.common.model.offer.EstateServiceType;

import java.util.Optional;

@Data
public class UserMailEntity {

    private String username;
    private EstateServiceType service;
    private Integer priceFrom;
    private Integer priceTo;
    private Double metersFrom;
    private Double metersTo;

    public LinkedMultiValueMap<String, String> buildQueryParams() {
        final LinkedMultiValueMap<String, String> queryMap = new LinkedMultiValueMap<>();
        Optional.ofNullable(service).ifPresent(serviceType -> queryMap.add("estateServiceType", serviceType.name()));
        Optional.ofNullable(priceFrom).ifPresent(priceF -> queryMap.add("priceFrom", priceF.toString()));
        Optional.ofNullable(priceTo).ifPresent(priceT -> queryMap.add("priceTo", priceT.toString()));
        Optional.ofNullable(metersFrom).ifPresent(metersF -> queryMap.add("metersFrom", metersF.toString()));
        Optional.ofNullable(metersTo).ifPresent(metersT -> queryMap.add("metersTo", metersT.toString()));
        return queryMap;
    }

}
