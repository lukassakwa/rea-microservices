package com.rea.system.offer.infrastructure.dataaccess.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import rea.system.common.model.offer.Floor;
import rea.system.common.model.offer.Room;
import rea.system.common.model.offer.ServiceType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
@Document(collection = "offer")
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    @Id
    protected String id;
    protected String publicId;
    protected String title;
    protected String description;
    protected List<String> images;
    protected Coordinates coordinates;
    protected String fullAddress;
    protected String href;
    @Indexed
    protected Integer price;
    @Indexed
    protected Double pricePerMeter;
    @Indexed
    protected Double meters;
    @Indexed
    protected Room roomNumber;
    @Indexed
    protected Floor floorNumber;
    @Indexed
    protected String duplicateKey;
    protected String contactPhone;
    protected Floor buildingFloorNumbers;
    protected Integer buildingYear;
    @Indexed
    protected LocalDateTime createdAt;
    @Indexed
    protected LocalDateTime modifiedAt;
    protected ServiceType serviceType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(id, offer.id) && Objects.equals(title, offer.title) && Objects.equals(description, offer.description) && Objects.equals(images, offer.images) && Objects.equals(coordinates, offer.coordinates) && Objects.equals(fullAddress, offer.fullAddress) && Objects.equals(href, offer.href) && Objects.equals(price, offer.price) && Objects.equals(pricePerMeter, offer.pricePerMeter) && Objects.equals(meters, offer.meters) && roomNumber == offer.roomNumber && floorNumber == offer.floorNumber && Objects.equals(duplicateKey, offer.duplicateKey) && Objects.equals(contactPhone, offer.contactPhone) && buildingFloorNumbers == offer.buildingFloorNumbers && Objects.equals(buildingYear, offer.buildingYear) && Objects.equals(createdAt, offer.createdAt) && Objects.equals(modifiedAt, offer.modifiedAt) && serviceType == offer.serviceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, images, coordinates, fullAddress, href, price, pricePerMeter, meters, roomNumber, floorNumber, duplicateKey, contactPhone, buildingFloorNumbers, buildingYear, createdAt, modifiedAt, serviceType);
    }
}
