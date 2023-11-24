package com.rea.system.offer.infrastructure.dataaccess.mapper;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalRentOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalSellOffer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoricalOfferMapper {

    HistoricalRentOffer toRentEntity(ResolveOffer resolveOffer);

    HistoricalSellOffer toSellEntity(ResolveOffer resolveOffer);

    ResolveOffer toResolveRentDto(HistoricalRentOffer offer);

    ResolveOffer toResolveSellDto(HistoricalSellOffer offer);

}
