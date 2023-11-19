package com.rea.system.intent.user;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import rea.system.common.intent.user.UserIntentPayload;

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

}
