package com.rea.system.mail.domain;

import com.rea.system.mail.domain.core.MailEntity;
import com.rea.system.mail.domain.core.OfferMailEntity;
import com.rea.system.mail.domain.core.UserMailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MailMapper {

    @Mapping(target = "username", source = "userMailEntity.username")
    @Mapping(target = "offersEntity", source = "offersEntity")
    MailEntity toEntity(List<OfferMailEntity> offersEntity, UserMailEntity userMailEntity);

}
