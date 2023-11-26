package com.rea.system.mail.infrastructure.web.client;

import com.rea.system.mail.domain.core.MailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import rea.system.common.aggregate.MailUserOfferAggregateResponse;

@Mapper(componentModel = "spring")
public interface MailClientMapper {

    @Mapping(target = "username", source = "mailUserOfferAggregateResponse.username")
    @Mapping(target = "offersEntity", source = "mailUserOfferAggregateResponse.offersEntity")
    MailEntity toEntity(MailUserOfferAggregateResponse mailUserOfferAggregateResponse);

}
