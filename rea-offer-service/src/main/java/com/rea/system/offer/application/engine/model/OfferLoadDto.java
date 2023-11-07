package com.rea.system.offer.application.engine.model;

import lombok.Builder;
import lombok.Data;
import rea.system.common.model.EstateServiceType;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class OfferLoadDto {

    EstateServiceType estateServiceType;
    @Builder.Default
    List<String> offersUrl = new ArrayList<>();

}
