package com.rea.system.offer.infrastructure.dataaccess.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "sell_offer")
@EqualsAndHashCode(callSuper = true)
public class SellOffer extends Offer {
}