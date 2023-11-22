package com.rea.system.offer.application.domain.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rea.system.common.model.offer.EstateServiceType;
import rea.system.common.model.offer.Floor;
import rea.system.common.model.offer.Room;
import rea.system.common.model.offer.ServiceType;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DomainOffer {

    public static final String MODIFIED_DATE = "modifiedAt";
    public static final String ID = "_id";

    private String id;
    private String publicId;
    private String title;
    private String description;
    private List<String> images;
    private String fullAddress;
    private Coordinates coordinates;
    private String href;
    private Integer price;
    private Double pricePerMeter;
    private String contactPhone;
    private Room roomNumber;
    private Floor floorNumber;
    private Floor buildingFloorNumbers;
    private Integer buildingYear;
    private EstateServiceType estateServiceType;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private Double meters;
    private String duplicateKey;
    private ServiceType serviceType;

}
