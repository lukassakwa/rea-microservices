package com.rea.system.user.infrastruture.resource.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rea.system.common.model.offer.EstateServiceType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPayload {

    private String userId;
    private String username;
    private EstateServiceType service;
    private Integer priceFrom;
    private Integer priceTo;
    private Double metersFrom;
    private Double metersTo;

}
