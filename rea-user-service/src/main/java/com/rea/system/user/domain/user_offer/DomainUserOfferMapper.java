package com.rea.system.user.domain.user_offer;

import com.rea.system.user.domain.user_offer.core.UserOfferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DomainUserOfferMapper {

    @Mapping(target = "userId", source = "entity.userId")
    @Mapping(target = "userOffersId", source = "entity.userOffersId")
    @Mapping(target = "offerId", source = "payload.offerId")
    @Mapping(target = "operationType", source = "payload.operationType")
    UserOfferEntity toEntity(UserOfferEntity entity, DomainUserOfferPayload payload);

}
