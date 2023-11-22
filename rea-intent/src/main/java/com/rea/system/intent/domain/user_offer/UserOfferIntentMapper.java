package com.rea.system.intent.domain.user_offer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import rea.system.common.intent.user_offer.UserOfferIntentPayload;

@Mapper(componentModel = "spring")
public interface UserOfferIntentMapper {

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "offerId", source = "payload.offerId")
    @Mapping(target = "operationType", source = "payload.operationType")
    UserOfferIntentPayload toPayload(String userId, UserOfferIntentPayload payload);

}
