package com.rea.system.offer.infrastructure.dataaccess.service;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.domain.entity.Fillter;

import java.util.List;

public interface AvailableDomainOfferService {

    List<DomainOffer> findOffersById(Fillter fillter, int pageIndex, int pageSize);

    DomainOffer findById(String offerId);

}
