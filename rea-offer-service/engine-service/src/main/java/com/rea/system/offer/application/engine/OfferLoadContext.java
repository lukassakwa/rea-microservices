package com.rea.system.offer.application.engine;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import rea.system.common.model.offer.EstateServiceType;

@Getter
@Setter
@Builder
public class OfferLoadContext {

    private EstateServiceType estateServiceType;
    private String url;

    static OfferLoadContext buildOfferContext(String url, OfferLoadDto offerLoadDto) {
        return OfferLoadContext.builder()
                .url(url)
                .estateServiceType(offerLoadDto.getEstateServiceType())
                .build();
    }

}
