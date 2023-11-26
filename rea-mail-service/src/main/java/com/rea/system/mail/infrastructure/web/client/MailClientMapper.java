package com.rea.system.mail.infrastructure.web.client;

import com.rea.system.mail.domain.core.OfferMailEntity;
import com.rea.system.mail.domain.core.UserMailEntity;
import org.mapstruct.Mapper;
import rea.system.common.mail.OfferMailResponse;
import rea.system.common.mail.UserMailResponse;

@Mapper(componentModel = "spring")
public interface MailClientMapper {

    UserMailEntity toEntity(UserMailResponse userMailResponse);

    OfferMailEntity toEntity(OfferMailResponse offerMailResponse);

}
