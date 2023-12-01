package com.rea.system.intent.domain.user;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.rea.system.intent.infrastructure.web.model.user.UserIntentPayload;
import com.rea.system.intent.infrastructure.web.model.user.UserOfferIntentPayload;

@Mapper(componentModel = "spring")
public interface UserIntentMapper {

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "service", source = "userIntentPayload.service")
    @Mapping(target = "priceFrom", source = "userIntentPayload.priceFrom")
    @Mapping(target = "priceTo", source = "userIntentPayload.priceTo")
    @Mapping(target = "metersFrom", source = "userIntentPayload.metersFrom")
    @Mapping(target = "metersTo", source = "userIntentPayload.metersTo")
    UserIntentPayload update(String userId, String username, UserIntentPayload userIntentPayload);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "offerId", source = "payload.offerId")
    @Mapping(target = "operationType", source = "payload.operationType")
    UserOfferIntentPayload toPayload(String userId, UserOfferIntentPayload payload);

}
