package com.rea.system.aggregate.infrastructure.web.resource.mail;

import com.rea.system.aggregate.domain.mail.core.MailUserOfferEntity;
import org.mapstruct.Mapper;
import com.rea.system.aggregate.infrastructure.web.model.MailUserOfferAggregateResponse;

@Mapper(componentModel = "spring")
public interface MailResponseMapper {

    MailUserOfferAggregateResponse toResponse(MailUserOfferEntity mailUserOfferEntity);

}
