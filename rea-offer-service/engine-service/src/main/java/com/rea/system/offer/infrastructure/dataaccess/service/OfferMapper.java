package com.rea.system.offer.infrastructure.dataaccess.service;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalRentOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalSellOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.RentOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.SellOffer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    SellOffer toSellEntity(ResolveOffer offer);

    RentOffer toRentEntity(ResolveOffer offer);

    ResolveOffer toResolveSellDto(SellOffer offer);

    ResolveOffer toResolveRentDto(RentOffer offer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    ResolveOffer updateOffer(@MappingTarget ResolveOffer target, ResolveOffer update);

    HistoricalRentOffer toHistoricalRentEntity(ResolveOffer resolveOffer);

    HistoricalSellOffer toHistoricalSellEntity(ResolveOffer resolveOffer);

    ResolveOffer toResolveRentDto(HistoricalRentOffer offer);

    ResolveOffer toResolveSellDto(HistoricalSellOffer offer);

}
