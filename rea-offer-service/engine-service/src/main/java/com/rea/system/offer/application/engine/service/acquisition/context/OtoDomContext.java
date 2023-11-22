package com.rea.system.offer.application.engine.service.acquisition.context;

import com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.simpleOffer.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class OtoDomContext implements GeneralOfferContext {

    private static final String OFFER_BASE_URL = "https://www.otodom.pl/pl/oferta/";

    private Item offerItem;

    @Override
    public String getDetailsUrl() {
        return OFFER_BASE_URL + offerItem.getSlug();
    }
}
