package com.rea.system.user.infrastruture.resource.user_offer;

import com.rea.system.user.domain.user_offer.DomainUserOfferPayload;
import com.rea.system.user.infrastruture.resource.model.UserOfferPayload;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserOfferIntentMapper {

    DomainUserOfferPayload mapToDomain(UserOfferPayload userOfferIntentPayload);

}
