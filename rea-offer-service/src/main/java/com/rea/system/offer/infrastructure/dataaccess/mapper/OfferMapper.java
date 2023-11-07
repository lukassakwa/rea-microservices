package com.rea.system.offer.infrastructure.dataaccess.mapper;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.RentOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.SellOffer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    SellOffer toSellEntity(ResolveOffer offer);

    RentOffer toRentEntity(ResolveOffer offer);

    ResolveOffer toResolveSellDto(SellOffer offer);

    DomainOffer toDomainSellDto(SellOffer offer);

    ResolveOffer toResolveRentDto(RentOffer offer);

    DomainOffer toDomainRentDto(RentOffer offer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    ResolveOffer updateOffer(@MappingTarget ResolveOffer target, ResolveOffer update);

}
