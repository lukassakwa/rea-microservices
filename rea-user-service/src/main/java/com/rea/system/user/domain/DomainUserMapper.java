package com.rea.system.user.domain;

import com.rea.system.user.domain.core.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DomainUserMapper {

    @Mapping(target = "id", source = "target.id")
    @Mapping(target = "userId", source = "target.userId")
    @Mapping(target = "username", source = "source.username")
    @Mapping(target = "userFilterSettingsEntity", source = "source.userFilterSettingsEntity")
    UserEntity update(UserEntity target, UserEntity source);

}
