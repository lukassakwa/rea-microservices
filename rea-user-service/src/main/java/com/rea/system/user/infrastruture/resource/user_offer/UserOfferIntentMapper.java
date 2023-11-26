package com.rea.system.user.infrastruture.resource.user_offer;

import com.rea.system.user.domain.user_offer.DomainUserOfferPayload;
import org.mapstruct.Mapper;
import rea.system.common.intent.user_offer.UserOfferIntentPayload;

@Mapper(componentModel = "spring")
public interface UserOfferIntentMapper {

    DomainUserOfferPayload mapToDomain(UserOfferIntentPayload userOfferIntentPayload);

}
