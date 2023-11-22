package com.rea.system.offer.infrastructure.web.resource;

import com.rea.system.offer.application.domain.core.DomainOffer;
import org.mapstruct.Mapper;
import rea.system.common.intent.offer.HistoricalOfferIntentResponse;
import rea.system.common.intent.offer.OfferIntentResponse;

@Mapper(componentModel = "spring")
public interface OfferResponseMapper {

    OfferIntentResponse toResponse(DomainOffer domainOffer);

    HistoricalOfferIntentResponse toHistoricalResponse(DomainOffer domainOffer);

}
