package com.rea.system.offer.application.engine;

import com.rea.system.offer.application.engine.model.OfferLoadDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import rea.system.common.model.EstateServiceType;

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
