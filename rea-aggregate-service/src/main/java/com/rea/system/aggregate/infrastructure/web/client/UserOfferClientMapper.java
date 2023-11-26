package com.rea.system.aggregate.infrastructure.web.client;

import com.rea.system.aggregate.domain.mail.core.OfferMailEntity;
import com.rea.system.aggregate.domain.mail.core.UserMailEntity;
import com.rea.system.aggregate.domain.user_offer.core.OfferAggregateEntity;
import org.mapstruct.Mapper;
import com.rea.system.aggregate.infrastructure.web.model.OfferAggregateResponse;
import com.rea.system.aggregate.infrastructure.web.model.OfferMailResponse;
import com.rea.system.aggregate.infrastructure.web.model.UserMailResponse;

@Mapper(componentModel = "spring")
public interface UserOfferClientMapper {

    UserMailEntity toEntity(UserMailResponse userMailResponse);

    OfferMailEntity toEntity(OfferMailResponse offerMailResponse);

    OfferAggregateEntity toEntity(OfferAggregateResponse offerMailResponse);

}
