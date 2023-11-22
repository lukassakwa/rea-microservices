package com.rea.system.offer.infrastructure.dataaccess.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "rent_offer")
@EqualsAndHashCode(callSuper = true)
public class RentOffer extends Offer {
}
