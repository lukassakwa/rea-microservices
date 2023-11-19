package com.rea.system.user.domain;

import com.rea.system.user.domain.core.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DomainUserSettingsMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    UserEntity update(UserEntity target, UserEntity source);

}
