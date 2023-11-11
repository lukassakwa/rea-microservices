package com.rea.system.offer.application.engine.entity;

import lombok.*;
import org.apache.commons.lang3.ObjectUtils;
import rea.system.common.model.EstateServiceType;
import rea.system.common.model.Floor;
import rea.system.common.model.Room;
import rea.system.common.model.ServiceType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResolveOffer {

    private final static String UNIQUE_KEY_JOINER = "##";

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

    public boolean isOfferValid() {
        return !ObjectUtils.anyNull(price, meters, roomNumber, floorNumber, buildingFloorNumbers, buildingYear)
                && !coordinates.areCoordinatesInValid();
    }

    public ResolveOffer prepareKeyValues() {
        this.duplicateKey = String.join(UNIQUE_KEY_JOINER,
                coordinates.getParsedLatitude(),
                coordinates.getParsedLongitude(),
                getParsedMeters(),
                roomNumber.name(),
                floorNumber.name(),
                buildingFloorNumbers.name(),
                buildingYear.toString()
        );
        this.serviceType = ServiceType.getServiceType(href);
        return this;
    }

    public void updateCreatedDate() {
        this.createdAt = LocalDateTime.now();
    }

    public void updateModifiedDate() {
        this.modifiedAt = LocalDateTime.now();
    }

    public void processDuplicateData() {
        this.publicId = this.id;
    }

    private String getParsedMeters() {
        if (meters == null) {
            return BigDecimal.ZERO.toString();
        }
        return new BigDecimal(meters).setScale(2, RoundingMode.HALF_EVEN).toString();
    }

    public int order() {
        return serviceType.getIndex();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResolveOffer resolveOffer = (ResolveOffer) o;
        return  coordinates.equals(resolveOffer.coordinates)
                && Objects.equals(getParsedMeters(), resolveOffer.getParsedMeters())
                && roomNumber == resolveOffer.roomNumber
                && floorNumber == resolveOffer.floorNumber
                && buildingFloorNumbers == resolveOffer.buildingFloorNumbers
                && Objects.equals(buildingYear, resolveOffer.buildingYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates.hashCode(), getParsedMeters(), roomNumber, floorNumber, buildingFloorNumbers, buildingYear);
    }
}
