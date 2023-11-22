package com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rea.system.offer.application.engine.OfferLoadContext;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.general.GratkaSimpleOffer;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.specify.Localization;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.service.acquisition.context.GratkaOfferContext;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.OfferScrapperService;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.GratkaContext;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.specify.GratkaDetailsOffer;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.specify.GratkaMainOffer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import rea.system.common.model.offer.ServiceType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GratkaOfferScraper implements OfferScrapperService<GratkaOfferContext> {

    private final ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public List<GratkaOfferContext> generalOffersInfo(Document document) {
        String json = document.selectFirst("script[type=\"application/ld+json\"]").data();
        GratkaSimpleOffer gratkaSimpleOffer = objectMapper.readValue(json, GratkaSimpleOffer.class);
        return gratkaSimpleOffer.getMainEntity().getItemListElement().stream()
                .map(item -> GratkaOfferContext.builder().offerItem(item).build())
                .collect(Collectors.toList());
    }

    @Override
    @SneakyThrows
    public ResolveOffer specificOffer(GratkaOfferContext context, Document document, OfferLoadContext offerLoadContext) {
        String mainJson = document.selectFirst("script:containsData(id_oferty)").toString();
        String parsedJson = GratkaJsonUtil.createJsonFromHtml(mainJson);
        GratkaMainOffer gratkaMainOffer = objectMapper.readValue(parsedJson, GratkaMainOffer.class);

        String localizationText = document.selectFirst("script:containsData(setAddress();)").toString();
        String localizationJson = GratkaJsonUtil.createLocalizationJsonFromHtml(localizationText);
        Localization localization = objectMapper.readValue(localizationJson, Localization.class);

        String detailsJson = document.select("script[type=\"application/ld+json\"]").get(1).data();
        GratkaDetailsOffer gratkaDetailsOffer = objectMapper.readValue(detailsJson, GratkaDetailsOffer.class);

        Element element = document.select("b[data-cy=liczba-pieter-w-budynku]").first();
        String buildingFloorNums = Optional.ofNullable(element).map(Element::text).orElse(null);


        GratkaContext gratkaContext = GratkaContext.builder()
                .gratkaMainOffer(gratkaMainOffer)
                .details(gratkaDetailsOffer)
                .localization(localization)
                .buildingFloorNum(buildingFloorNums)
                .context(offerLoadContext)
                .build();

        ResolveOffer resolveOffer = GratkaOfferMapper.map(gratkaContext);
        return resolveOffer;
    }

    @Override
    public ServiceType getServiceName() {
        return ServiceType.GRATKA;
    }

}
