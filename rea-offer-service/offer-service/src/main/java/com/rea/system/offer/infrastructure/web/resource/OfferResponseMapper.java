package com.rea.system.offer.infrastructure.web.resource;

import com.rea.system.offer.application.domain.core.DomainOffer;
import com.rea.system.offer.infrastructure.web.model.HistoricalOfferResponse;
import com.rea.system.offer.infrastructure.web.model.OfferResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferResponseMapper {

    OfferResponse toResponse(DomainOffer domainOffer);

    HistoricalOfferResponse toHistoricalResponse(DomainOffer domainOffer);

}
