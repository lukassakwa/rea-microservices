package com.rea.system.aggregate.infrastructure.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rea.system.common.model.offer.Floor;
import rea.system.common.model.offer.Room;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferAggregateResponse {

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
