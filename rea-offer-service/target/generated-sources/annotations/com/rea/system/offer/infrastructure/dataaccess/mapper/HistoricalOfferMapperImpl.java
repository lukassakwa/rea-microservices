package com.rea.system.offer.infrastructure.dataaccess.mapper;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.engine.entity.Coordinates;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalRentOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalSellOffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-08T01:00:31+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class HistoricalOfferMapperImpl implements HistoricalOfferMapper {

    @Override
    public HistoricalRentOffer toRentEntity(ResolveOffer resolveOffer) {
        if ( resolveOffer == null ) {
            return null;
        }

        HistoricalRentOffer historicalRentOffer = new HistoricalRentOffer();

        historicalRentOffer.setId( resolveOffer.getId() );
        historicalRentOffer.setPublicId( resolveOffer.getPublicId() );
        historicalRentOffer.setTitle( resolveOffer.getTitle() );
        historicalRentOffer.setDescription( resolveOffer.getDescription() );
        List<String> list = resolveOffer.getImages();
        if ( list != null ) {
            historicalRentOffer.setImages( new ArrayList<String>( list ) );
        }
        historicalRentOffer.setCoordinates( coordinatesToCoordinates( resolveOffer.getCoordinates() ) );
        historicalRentOffer.setFullAddress( resolveOffer.getFullAddress() );
        historicalRentOffer.setHref( resolveOffer.getHref() );
        historicalRentOffer.setPrice( resolveOffer.getPrice() );
        historicalRentOffer.setPricePerMeter( resolveOffer.getPricePerMeter() );
        historicalRentOffer.setMeters( resolveOffer.getMeters() );
        historicalRentOffer.setRoomNumber( resolveOffer.getRoomNumber() );
        historicalRentOffer.setFloorNumber( resolveOffer.getFloorNumber() );
        historicalRentOffer.setDuplicateKey( resolveOffer.getDuplicateKey() );
        historicalRentOffer.setContactPhone( resolveOffer.getContactPhone() );
        historicalRentOffer.setBuildingFloorNumbers( resolveOffer.getBuildingFloorNumbers() );
        historicalRentOffer.setBuildingYear( resolveOffer.getBuildingYear() );
        historicalRentOffer.setCreatedAt( resolveOffer.getCreatedAt() );
        historicalRentOffer.setModifiedAt( resolveOffer.getModifiedAt() );
        historicalRentOffer.setServiceType( resolveOffer.getServiceType() );

        return historicalRentOffer;
    }

    @Override
    public HistoricalSellOffer toSellEntity(ResolveOffer resolveOffer) {
        if ( resolveOffer == null ) {
            return null;
        }

        HistoricalSellOffer historicalSellOffer = new HistoricalSellOffer();

        historicalSellOffer.setId( resolveOffer.getId() );
        historicalSellOffer.setPublicId( resolveOffer.getPublicId() );
        historicalSellOffer.setTitle( resolveOffer.getTitle() );
        historicalSellOffer.setDescription( resolveOffer.getDescription() );
        List<String> list = resolveOffer.getImages();
        if ( list != null ) {
            historicalSellOffer.setImages( new ArrayList<String>( list ) );
        }
        historicalSellOffer.setCoordinates( coordinatesToCoordinates( resolveOffer.getCoordinates() ) );
        historicalSellOffer.setFullAddress( resolveOffer.getFullAddress() );
        historicalSellOffer.setHref( resolveOffer.getHref() );
        historicalSellOffer.setPrice( resolveOffer.getPrice() );
        historicalSellOffer.setPricePerMeter( resolveOffer.getPricePerMeter() );
        historicalSellOffer.setMeters( resolveOffer.getMeters() );
        historicalSellOffer.setRoomNumber( resolveOffer.getRoomNumber() );
        historicalSellOffer.setFloorNumber( resolveOffer.getFloorNumber() );
        historicalSellOffer.setDuplicateKey( resolveOffer.getDuplicateKey() );
        historicalSellOffer.setContactPhone( resolveOffer.getContactPhone() );
        historicalSellOffer.setBuildingFloorNumbers( resolveOffer.getBuildingFloorNumbers() );
        historicalSellOffer.setBuildingYear( resolveOffer.getBuildingYear() );
        historicalSellOffer.setCreatedAt( resolveOffer.getCreatedAt() );
        historicalSellOffer.setModifiedAt( resolveOffer.getModifiedAt() );
        historicalSellOffer.setServiceType( resolveOffer.getServiceType() );

        return historicalSellOffer;
    }

    @Override
    public ResolveOffer toResolveRentDto(HistoricalRentOffer offer) {
        if ( offer == null ) {
            return null;
        }

        ResolveOffer.ResolveOfferBuilder resolveOffer = ResolveOffer.builder();

        resolveOffer.id( offer.getId() );
        resolveOffer.publicId( offer.getPublicId() );
        resolveOffer.title( offer.getTitle() );
        resolveOffer.description( offer.getDescription() );
        List<String> list = offer.getImages();
        if ( list != null ) {
            resolveOffer.images( new ArrayList<String>( list ) );
        }
        resolveOffer.fullAddress( offer.getFullAddress() );
        resolveOffer.coordinates( coordinatesToCoordinates1( offer.getCoordinates() ) );
        resolveOffer.href( offer.getHref() );
        resolveOffer.price( offer.getPrice() );
        resolveOffer.pricePerMeter( offer.getPricePerMeter() );
        resolveOffer.contactPhone( offer.getContactPhone() );
        resolveOffer.roomNumber( offer.getRoomNumber() );
        resolveOffer.floorNumber( offer.getFloorNumber() );
        resolveOffer.buildingFloorNumbers( offer.getBuildingFloorNumbers() );
        resolveOffer.buildingYear( offer.getBuildingYear() );
        resolveOffer.createdAt( offer.getCreatedAt() );
        resolveOffer.modifiedAt( offer.getModifiedAt() );
        resolveOffer.meters( offer.getMeters() );
        resolveOffer.duplicateKey( offer.getDuplicateKey() );
        resolveOffer.serviceType( offer.getServiceType() );

        return resolveOffer.build();
    }

    @Override
    public ResolveOffer toResolveSellDto(HistoricalSellOffer offer) {
        if ( offer == null ) {
            return null;
        }

        ResolveOffer.ResolveOfferBuilder resolveOffer = ResolveOffer.builder();

        resolveOffer.id( offer.getId() );
        resolveOffer.publicId( offer.getPublicId() );
        resolveOffer.title( offer.getTitle() );
        resolveOffer.description( offer.getDescription() );
        List<String> list = offer.getImages();
        if ( list != null ) {
            resolveOffer.images( new ArrayList<String>( list ) );
        }
        resolveOffer.fullAddress( offer.getFullAddress() );
        resolveOffer.coordinates( coordinatesToCoordinates1( offer.getCoordinates() ) );
        resolveOffer.href( offer.getHref() );
        resolveOffer.price( offer.getPrice() );
        resolveOffer.pricePerMeter( offer.getPricePerMeter() );
        resolveOffer.contactPhone( offer.getContactPhone() );
        resolveOffer.roomNumber( offer.getRoomNumber() );
        resolveOffer.floorNumber( offer.getFloorNumber() );
        resolveOffer.buildingFloorNumbers( offer.getBuildingFloorNumbers() );
        resolveOffer.buildingYear( offer.getBuildingYear() );
        resolveOffer.createdAt( offer.getCreatedAt() );
        resolveOffer.modifiedAt( offer.getModifiedAt() );
        resolveOffer.meters( offer.getMeters() );
        resolveOffer.duplicateKey( offer.getDuplicateKey() );
        resolveOffer.serviceType( offer.getServiceType() );

        return resolveOffer.build();
    }

    @Override
    public DomainOffer toDomainRentDto(HistoricalRentOffer offer) {
        if ( offer == null ) {
            return null;
        }

        DomainOffer domainOffer = new DomainOffer();

        domainOffer.setId( offer.getId() );
        domainOffer.setPublicId( offer.getPublicId() );
        domainOffer.setTitle( offer.getTitle() );
        domainOffer.setDescription( offer.getDescription() );
        List<String> list = offer.getImages();
        if ( list != null ) {
            domainOffer.setImages( new ArrayList<String>( list ) );
        }
        domainOffer.setFullAddress( offer.getFullAddress() );
        domainOffer.setCoordinates( coordinatesToCoordinates1( offer.getCoordinates() ) );
        domainOffer.setHref( offer.getHref() );
        domainOffer.setPrice( offer.getPrice() );
        domainOffer.setPricePerMeter( offer.getPricePerMeter() );
        domainOffer.setContactPhone( offer.getContactPhone() );
        domainOffer.setRoomNumber( offer.getRoomNumber() );
        domainOffer.setFloorNumber( offer.getFloorNumber() );
        domainOffer.setBuildingFloorNumbers( offer.getBuildingFloorNumbers() );
        domainOffer.setBuildingYear( offer.getBuildingYear() );
        domainOffer.setCreatedAt( offer.getCreatedAt() );
        domainOffer.setModifiedAt( offer.getModifiedAt() );
        domainOffer.setMeters( offer.getMeters() );
        domainOffer.setDuplicateKey( offer.getDuplicateKey() );
        domainOffer.setServiceType( offer.getServiceType() );

        return domainOffer;
    }

    @Override
    public DomainOffer toDomainSellDto(HistoricalSellOffer offer) {
        if ( offer == null ) {
            return null;
        }

        DomainOffer domainOffer = new DomainOffer();

        domainOffer.setId( offer.getId() );
        domainOffer.setPublicId( offer.getPublicId() );
        domainOffer.setTitle( offer.getTitle() );
        domainOffer.setDescription( offer.getDescription() );
        List<String> list = offer.getImages();
        if ( list != null ) {
            domainOffer.setImages( new ArrayList<String>( list ) );
        }
        domainOffer.setFullAddress( offer.getFullAddress() );
        domainOffer.setCoordinates( coordinatesToCoordinates1( offer.getCoordinates() ) );
        domainOffer.setHref( offer.getHref() );
        domainOffer.setPrice( offer.getPrice() );
        domainOffer.setPricePerMeter( offer.getPricePerMeter() );
        domainOffer.setContactPhone( offer.getContactPhone() );
        domainOffer.setRoomNumber( offer.getRoomNumber() );
        domainOffer.setFloorNumber( offer.getFloorNumber() );
        domainOffer.setBuildingFloorNumbers( offer.getBuildingFloorNumbers() );
        domainOffer.setBuildingYear( offer.getBuildingYear() );
        domainOffer.setCreatedAt( offer.getCreatedAt() );
        domainOffer.setModifiedAt( offer.getModifiedAt() );
        domainOffer.setMeters( offer.getMeters() );
        domainOffer.setDuplicateKey( offer.getDuplicateKey() );
        domainOffer.setServiceType( offer.getServiceType() );

        return domainOffer;
    }

    protected com.rea.system.offer.infrastructure.dataaccess.entity.Coordinates coordinatesToCoordinates(Coordinates coordinates) {
        if ( coordinates == null ) {
            return null;
        }

        String latitude = null;
        String longitude = null;

        latitude = coordinates.getLatitude();
        longitude = coordinates.getLongitude();

        com.rea.system.offer.infrastructure.dataaccess.entity.Coordinates coordinates1 = new com.rea.system.offer.infrastructure.dataaccess.entity.Coordinates( latitude, longitude );

        return coordinates1;
    }

    protected Coordinates coordinatesToCoordinates1(com.rea.system.offer.infrastructure.dataaccess.entity.Coordinates coordinates) {
        if ( coordinates == null ) {
            return null;
        }

        String latitude = null;
        String longitude = null;

        latitude = coordinates.getLatitude();
        longitude = coordinates.getLongitude();

        Coordinates coordinates1 = new Coordinates( latitude, longitude );

        return coordinates1;
    }
}
