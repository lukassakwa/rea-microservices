package com.rea.system.offer.application.engine.service.acquisition.context;

import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.general.ItemListElement;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class GratkaOfferContext implements GeneralOfferContext {

    private ItemListElement offerItem;

    @Override
    public boolean filterOffers() {
        return offerItem.getItemOffered().getUrl() != null;
    }

    @Override
    public String getDetailsUrl() {
        return offerItem.getUrl();
    }


}
