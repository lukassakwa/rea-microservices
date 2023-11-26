package com.rea.system.aggregate.domain.mail;

import com.rea.system.aggregate.domain.mail.core.MailUserOfferEntity;
import com.rea.system.aggregate.domain.mail.core.OfferMailEntity;
import com.rea.system.aggregate.domain.mail.core.UserMailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DomainMailUserOfferMapper {

    @Mapping(target = "username", source = "userMailEntity.username")
    @Mapping(target = "offersEntity", source = "offersEntity")
    MailUserOfferEntity toEntity(List<OfferMailEntity> offersEntity, UserMailEntity userMailEntity);

}
