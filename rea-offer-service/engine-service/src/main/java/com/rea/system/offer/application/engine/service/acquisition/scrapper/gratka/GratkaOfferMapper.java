package com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka;

import com.rea.system.offer.application.engine.service.acquisition.scrapper.common.MapperUtils;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.specify.Localization;
import com.rea.system.offer.application.engine.entity.Coordinates;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.GratkaContext;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.specify.Graph;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.specify.GratkaDetailsOffer;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.specify.GratkaMainOffer;
import org.springframework.stereotype.Component;
import rea.system.common.model.offer.Floor;
import rea.system.common.model.offer.Room;

import java.util.List;
import java.util.Optional;

@Component
class GratkaOfferMapper {

    static ResolveOffer map(GratkaContext context) {
        ResolveOffer resolveOffer = ResolveOffer.builder().build();

        GratkaMainOffer gratkaMainOffer = context.getGratkaMainOffer();
        GratkaDetailsOffer details = context.getDetails();
        Graph graph = details.getGraph().get(0);

        Optional.ofNullable(gratkaMainOffer.getCena()).ifPresent(resolveOffer::setPrice);
        Optional.ofNullable(graph.getNumberOfRooms()).ifPresent(roomNumber -> resolveOffer.setRoomNumber(Room.getRoom(roomNumber.toString())));
        Optional.ofNullable(graph.getFloorLevel()).ifPresent(floorLevel -> resolveOffer.setFloorNumber(Floor.getFloorNum(floorLevel.toString())));
        Optional.ofNullable(gratkaMainOffer.getPowierzchniaM2()).ifPresent(meters -> resolveOffer.setMeters(Double.valueOf(meters)));

        Coordinates coordinates = new Coordinates(
                graph.getGeo().getLatitude(),
                graph.getGeo().getLongitude()
        );
        resolveOffer.setCoordinates(coordinates);

        Optional.ofNullable(graph.getDescription()).ifPresent(description -> resolveOffer.setDescription(MapperUtils.removeHtmlTags(description)));
        Optional.ofNullable(graph.getName()).ifPresent(resolveOffer::setTitle);
        Optional.ofNullable(graph.getImage()).ifPresent(images -> resolveOffer.setImages(List.of(images)));
        Optional.ofNullable(graph.getUrl()).ifPresent(resolveOffer::setHref);
        Optional.ofNullable(context.getLocalization()).ifPresent(localization -> resolveOffer.setFullAddress(mapAdress(localization)));
        Optional.ofNullable(graph.getYearBuilt()).ifPresent(resolveOffer::setBuildingYear);
        Optional.ofNullable(context.getBuildingFloorNum()).ifPresent(buildingFloorNm -> resolveOffer.setBuildingFloorNumbers(Floor.getFloorNum(buildingFloorNm)));
        resolveOffer.setEstateServiceType(context.getContext().getEstateServiceType());
        return resolveOffer;
    }

    private static String mapAdress(Localization localization) {
        StringBuilder plainAddress = new StringBuilder();
        Optional.ofNullable(localization.getLokalizacjaMiejscowosc()).ifPresent(s -> plainAddress.append(s).append(", "));
        Optional.ofNullable(localization.getLokalizacjaDzielnica()).ifPresent(s -> plainAddress.append(s).append(", "));
        Optional.ofNullable(localization.getLokalizacjaUlica()).ifPresent(plainAddress::append);
        return plainAddress.toString();
    }

}
