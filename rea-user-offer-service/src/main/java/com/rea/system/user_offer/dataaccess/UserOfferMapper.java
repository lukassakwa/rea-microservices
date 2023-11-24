package com.rea.system.user_offer.dataaccess;

import com.rea.system.user_offer.domain.core.UserOfferEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserOfferMapper {

    UserOfferEntity toEntity(UserOffer userOffer);

    UserOffer toModel(UserOfferEntity userOffer);

}
