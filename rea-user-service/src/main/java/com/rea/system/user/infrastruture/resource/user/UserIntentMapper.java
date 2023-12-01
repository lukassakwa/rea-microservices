package com.rea.system.user.infrastruture.resource.user;

import com.rea.system.user.domain.user.core.UserEntity;
import com.rea.system.user.infrastruture.resource.model.UserMailResponse;
import com.rea.system.user.infrastruture.resource.model.UserPayload;
import com.rea.system.user.infrastruture.resource.model.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserIntentMapper {

    @Mapping(target = "userFilterSettingsEntity.service", source = "service")
    @Mapping(target = "userFilterSettingsEntity.priceFrom", source = "priceFrom")
    @Mapping(target = "userFilterSettingsEntity.priceTo", source = "priceTo")
    @Mapping(target = "userFilterSettingsEntity.metersFrom", source = "metersFrom")
    @Mapping(target = "userFilterSettingsEntity.metersTo", source = "metersTo")
    UserEntity toEntity(UserPayload userIntentPayload);

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
    UserResponse toIntentResponse(UserEntity userEntity);


}
