package com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto;

import com.rea.system.offer.application.engine.OfferLoadContext;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.specify.GratkaDetailsOffer;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.specify.GratkaMainOffer;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.specify.Localization;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GratkaContext {
    private GratkaMainOffer gratkaMainOffer;
    private GratkaDetailsOffer details;
    private Localization localization;
    private OfferLoadContext context;
    private String buildingFloorNum;
}
