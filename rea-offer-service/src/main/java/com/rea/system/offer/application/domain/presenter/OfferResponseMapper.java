package com.rea.system.offer.application.domain.presenter;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import org.mapstruct.Mapper;
import rea.system.common.dto.offer.OfferDto;

@Mapper(componentModel = "spring")
public interface OfferResponseMapper {

    OfferDto toResponse(DomainOffer domainOffer);

}
