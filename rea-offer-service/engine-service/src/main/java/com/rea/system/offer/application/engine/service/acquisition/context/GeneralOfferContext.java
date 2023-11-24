package com.rea.system.offer.application.engine.service.acquisition.context;

public interface GeneralOfferContext {

    String getDetailsUrl();

    default boolean filterOffers() {
        return true;
    }

}
