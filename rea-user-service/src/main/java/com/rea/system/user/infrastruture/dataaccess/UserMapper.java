package com.rea.system.user.infrastruture.dataaccess;


import com.rea.system.user.domain.user.core.UserEntity;
import com.rea.system.user.domain.user_offer.core.UserOfferEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toUserEntity(User user);

    User toModel(UserEntity userEntity);

    UserOfferEntity toUserOfferEntity(User user);

    User toModel(UserOfferEntity userOffer);

}
