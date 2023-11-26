package com.rea.system.aggregate.domain.user_offer.core;

import lombok.Data;
import rea.system.common.model.offer.Floor;
import rea.system.common.model.offer.Room;

import java.util.List;

@Data
public class OfferAggregateEntity {

    private String id;
    private String publicId;
    private List<String> images;
    private String href;
    private String title;
    private String description;
    private String fullAddress;
    private Integer price;
    private Double meters;
    private Room roomNumber;
    private Floor floor;

}
