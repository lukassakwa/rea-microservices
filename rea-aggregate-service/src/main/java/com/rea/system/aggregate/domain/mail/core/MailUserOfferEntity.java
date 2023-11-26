package com.rea.system.aggregate.domain.mail.core;

import lombok.Data;

import java.util.List;

@Data
public class MailUserOfferEntity {

    private String username;
    private List<OfferMailEntity> offersEntity;

}
