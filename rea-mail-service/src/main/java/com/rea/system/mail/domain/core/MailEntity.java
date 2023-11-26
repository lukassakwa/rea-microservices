package com.rea.system.mail.domain.core;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class MailEntity {

    private String username;
    private List<OfferMailEntity> offersEntity;

    public String offerContent() {
        return offersEntity.stream()
                .map(OfferMailEntity::getHtmlContent)
                .collect(Collectors.joining());
    }

}
