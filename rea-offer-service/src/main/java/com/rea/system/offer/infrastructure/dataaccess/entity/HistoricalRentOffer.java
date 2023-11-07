package com.rea.system.offer.infrastructure.dataaccess.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "historical_rent_offer")
@EqualsAndHashCode(callSuper = true)
public class HistoricalRentOffer extends Offer {
}
