package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom;

import com.rea.system.offer.application.engine.entity.Coordinates;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.OfferLoadContext;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.common.MapperUtils;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer.Ad;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer.DetailedOffer;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer.Image;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer.Location;
import rea.system.common.model.Floor;
import rea.system.common.model.Room;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class OtoDomMapper {

    private static final HashMap<String, String> floor = new HashMap<>();
    private static final String OFFER_BASE_URL = "https://www.otodom.pl/pl/oferta/";

    static {
        floor.put("ground_floor", "0");
        floor.put("floor_1", "1");
        floor.put("floor_2", "2");
        floor.put("floor_3", "3");
        floor.put("floor_4", "4");
        floor.put("floor_5", "5");
        floor.put("floor_6", "6");
        floor.put("floor_7", "7");
        floor.put("floor_8", "8");
        floor.put("floor_9", "9");
        floor.put("floor_10", "10");
        floor.put("floor_11", "");
        floor.put("floor_12", "");
        floor.put("floor_13", "");
        floor.put("floor_14", "");
    }

    static ResolveOffer map(DetailedOffer detailedOffer, OfferLoadContext context) {
        ResolveOffer resolveOffer = ResolveOffer.builder().build();
        Ad detailedOfferAd = detailedOffer.getAd();

        Optional.ofNullable(detailedOfferAd.getTarget().getPrice()).ifPresent(resolveOffer::setPrice);
        Optional.ofNullable(detailedOfferAd.getTarget().getRoomNum()).ifPresent(room -> resolveOffer.setRoomNumber(Room.getRoom(room)));
        Optional.ofNullable(detailedOfferAd.getTarget().getFloorNum()).ifPresent(floorNum -> resolveOffer.setFloorNumber(Floor.getFloorNum(floor.getOrDefault(floorNum, null))));
        Optional.ofNullable(detailedOfferAd.getTarget().getArea()).ifPresent(meters -> resolveOffer.setMeters(Double.valueOf(meters)));
        Optional.ofNullable(detailedOfferAd.getDescription()).ifPresent(decsript -> resolveOffer.setDescription(MapperUtils.removeHtmlTags(decsript)));

        Coordinates coordinates = new Coordinates(
                detailedOffer.getAd().getLocation().getCoordinates().getLatitude(),
                detailedOffer.getAd().getLocation().getCoordinates().getLongitude()
        );
        resolveOffer.setCoordinates(coordinates);

        Optional.ofNullable(detailedOfferAd.getTitle()).ifPresent(resolveOffer::setTitle);
        Optional.ofNullable(detailedOfferAd.getSlug()).ifPresent(slug -> resolveOffer.setHref(OFFER_BASE_URL + slug));
        Optional.ofNullable(detailedOfferAd.getImages()).ifPresent(image -> resolveOffer.setImages(mapImages(image)));
        Optional.ofNullable(detailedOfferAd.getTarget().getPricePerM()).ifPresent(resolveOffer::setPricePerMeter);
        Optional.ofNullable(detailedOffer.getAd().getLocation()).ifPresent(location -> resolveOffer.setFullAddress(mapAdress(location)));
        Optional.ofNullable(detailedOfferAd.getTarget().getBuildingFloorsNum()).ifPresent(buildingFloorsNum -> resolveOffer.setBuildingFloorNumbers(Floor.getFloorNum(buildingFloorsNum)));
        Optional.ofNullable(detailedOfferAd.getTarget().getBuildYear()).ifPresent(year -> resolveOffer.setBuildingYear(Integer.valueOf(year)));
        resolveOffer.setEstateServiceType(context.getEstateServiceType());
        return resolveOffer;
    }

    private static List<String> mapImages(List<Image> images) {
        return images.stream()
                .map(Image::getMedium)
                .collect(Collectors.toList());
    }

    private static String mapAdress(Location location) {
        StringBuilder plainAddress = new StringBuilder();
        Optional.ofNullable((location.getAddress().getCity())).ifPresent(s -> plainAddress.append(s.getName()).append(", "));
        Optional.ofNullable(location.getAddress().getDistrict()).ifPresent(s -> plainAddress.append(s.getName()).append(", "));
        Optional.ofNullable(location.getAddress().getStreet()).ifPresent(s -> plainAddress.append(s.getName()));
        return plainAddress.toString();
    }


}
