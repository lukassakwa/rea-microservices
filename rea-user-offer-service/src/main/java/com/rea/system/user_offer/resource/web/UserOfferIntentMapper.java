package com.rea.system.user_offer.resource.web;

import com.rea.system.user_offer.domain.DomainUserOfferPayload;
import com.rea.system.user_offer.domain.core.UserOfferEntity;
import org.mapstruct.Mapper;
import rea.system.common.intent.user_offer.UserOfferIntentPayload;
import rea.system.common.intent.user_offer.UserOfferIntentResponse;

@Mapper(componentModel = "spring")
public interface UserOfferIntentMapper {

    DomainUserOfferPayload mapToDomain(UserOfferIntentPayload userOfferIntentPayload);

}
