package com.rea.system.user.resource;

import com.rea.system.user.domain.core.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import rea.system.common.intent.user.UserIntentPayload;
import rea.system.common.intent.user.UserIntentResponse;
import rea.system.common.mail.UserMailResponse;

@Mapper(componentModel = "spring")
public interface UserIntentMapper {

    @Mapping(target = "userFilterSettingsEntity.service", source = "service")
    @Mapping(target = "userFilterSettingsEntity.priceFrom", source = "priceFrom")
    @Mapping(target = "userFilterSettingsEntity.priceTo", source = "priceTo")
    @Mapping(target = "userFilterSettingsEntity.metersFrom", source = "metersFrom")
    @Mapping(target = "userFilterSettingsEntity.metersTo", source = "metersTo")
    UserEntity toEntity(UserIntentPayload userIntentPayload);

    @Mapping(target = "service", source = "userFilterSettingsEntity.service")
    @Mapping(target = "priceFrom", source = "userFilterSettingsEntity.priceFrom")
    @Mapping(target = "priceTo", source = "userFilterSettingsEntity.priceTo")
    @Mapping(target = "metersFrom", source = "userFilterSettingsEntity.metersFrom")
    @Mapping(target = "metersTo", source = "userFilterSettingsEntity.metersTo")
    UserMailResponse toMailResponse(UserEntity userEntity);

    @Mapping(target = "service", source = "userFilterSettingsEntity.service")
    @Mapping(target = "priceFrom", source = "userFilterSettingsEntity.priceFrom")
    @Mapping(target = "priceTo", source = "userFilterSettingsEntity.priceTo")
    @Mapping(target = "metersFrom", source = "userFilterSettingsEntity.metersFrom")
    @Mapping(target = "metersTo", source = "userFilterSettingsEntity.metersTo")
    UserIntentResponse toIntentResponse(UserEntity userEntity);


}
