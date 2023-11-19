package com.rea.system.user.dataaccess;


import com.rea.system.user.domain.core.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(User user);

    User toModel(UserEntity userEntity);

}
