package com.rea.system.offer.infrastructure.dataaccess.service;

import com.rea.system.offer.application.domain.entity.DomainOffer;

import java.util.List;

public interface HistoricalDomainOfferService {

    List<DomainOffer> findByPublicId(String publicId);

}
