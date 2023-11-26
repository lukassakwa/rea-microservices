package com.rea.system.aggregate.infrastructure.web.resource.user_offer;

import com.rea.system.aggregate.domain.user_offer.core.OfferAggregateEntity;
import org.mapstruct.Mapper;
import com.rea.system.aggregate.infrastructure.web.model.OfferAggregateResponse;

@Mapper(componentModel = "spring")
public interface UserOfferResponseMapper {

    OfferAggregateResponse toResponse(OfferAggregateEntity entity);

}
