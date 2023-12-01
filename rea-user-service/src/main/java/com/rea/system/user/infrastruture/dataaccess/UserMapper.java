package com.rea.system.user.infrastruture.dataaccess;


import com.rea.system.user.domain.user.core.UserEntity;
import com.rea.system.user.domain.user_offer.core.UserOfferEntity;
import com.rea.system.user.infrastruture.dataaccess.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userFilterSettingsEntity", source = "user.userFilterSettings")
    UserEntity toUserEntity(User user);

    User toModel(UserEntity userEntity);

    UserOfferEntity toUserOfferEntity(User user);

    User toModel(UserOfferEntity userOffer);

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "userOffersId", source = "user.userOffersId")
    @Mapping(target = "username", source = "userEntity.username")
    @Mapping(target = "userFilterSettings", source = "userEntity.userFilterSettingsEntity")
    User update(User user, UserEntity userEntity);

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "userFilterSettings", source = "user.userFilterSettings")
    @Mapping(target = "userOffersId", source = "userEntity.userOffersId")
    User update(User user, UserOfferEntity userEntity);
}
