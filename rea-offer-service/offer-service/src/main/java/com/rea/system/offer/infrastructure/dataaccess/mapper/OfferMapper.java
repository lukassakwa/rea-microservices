package com.rea.system.offer.infrastructure.dataaccess.mapper;

import com.rea.system.offer.application.domain.core.DomainOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.RentOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.SellOffer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    DomainOffer toDomainSellDto(SellOffer offer);

    DomainOffer toDomainRentDto(RentOffer offer);

}
