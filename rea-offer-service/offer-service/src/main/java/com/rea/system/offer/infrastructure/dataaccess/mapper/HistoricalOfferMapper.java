package com.rea.system.offer.infrastructure.dataaccess.mapper;

import com.rea.system.offer.application.domain.core.DomainOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalRentOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalSellOffer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoricalOfferMapper {

    DomainOffer toDomainRentDto(HistoricalRentOffer offer);

    DomainOffer toDomainSellDto(HistoricalSellOffer offer);

}
