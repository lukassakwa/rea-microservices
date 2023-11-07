package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rea.system.offer.application.engine.OfferLoadContext;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.service.acquisition.context.OtoDomContext;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.OfferScrapperService;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer.DetailedOffer;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.simpleOffer.SimpleOffer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import rea.system.common.model.ServiceType;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OtoDomOfferScraper implements OfferScrapperService<OtoDomContext> {
    private static final String OPEN_JSON_VALUE = "\"items\":";
    private static final String CLOSE_JSON_VALUE = "\"trackingSet\":";
    private static final String DETAIL_OPEN_JSON_VALUE = "\"ad\":";
    private static final String DETAIL_CLOSE_JSON_VALUE = "\"googleApiKey\":";

    private final ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public List<OtoDomContext> generalOffersInfo(Document document) {
        String json = document.selectFirst("script[type=\"application/json\"]").toString();
        final String jsonOffer = OtoDomJsonUtil.createJsonFromHtml(json, OPEN_JSON_VALUE, CLOSE_JSON_VALUE);
        SimpleOffer simpleOffer = objectMapper.readValue(jsonOffer, SimpleOffer.class);
        return simpleOffer.getItems().stream()
                .map(item -> OtoDomContext.builder().offerItem(item).build())
                .collect(Collectors.toList());
    }

    @Override
    @SneakyThrows
    public ResolveOffer specificOffer(OtoDomContext context, Document document, OfferLoadContext offerLoadContext) {
        String json = document.selectFirst("script[type=\"application/json\"]").data();
        final String jsonOffer = OtoDomJsonUtil.createJsonFromHtml(json, DETAIL_OPEN_JSON_VALUE, DETAIL_CLOSE_JSON_VALUE);
        DetailedOffer detailedOffer = objectMapper.readValue(jsonOffer, DetailedOffer.class);
        ResolveOffer resolveOffer = OtoDomMapper.map(detailedOffer, offerLoadContext);
        return resolveOffer;
    }

    @Override
    public ServiceType getServiceName() {
        return ServiceType.OTO_DOM;
    }

}