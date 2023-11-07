package com.rea.system.offer.application.domain.presenter;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import rea.system.common.dto.OfferDto;

@Mapper(componentModel = "spring")
public interface OfferResponseMapper {

    OfferDto toResponse(DomainOffer domainOffer);

}
