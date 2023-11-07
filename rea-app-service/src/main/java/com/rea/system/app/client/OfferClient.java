package com.rea.system.app.client;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import rea.system.common.dto.OfferDto;
import rea.system.common.model.EstateServiceType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfferClient {

    private final WebClient webClient;

    public List<OfferDto> getOffers(EstateServiceType estateServiceType,
                                    String pageIndex,
                                    String pageSize,
                                    Integer priceFrom,
                                    Integer priceTo,
                                    Double metersFrom,
                                    Double metersTo) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("estateServiceType", estateServiceType.toString());
        params.add("pageIndex", pageIndex);
        params.add("pageSize", pageSize);
        Optional.ofNullable(priceFrom).ifPresent(priceF -> params.add("priceFrom", priceF.toString()));
        Optional.ofNullable(priceTo).ifPresent(priceT -> params.add("priceTo", priceT.toString()));
        Optional.ofNullable(metersFrom).ifPresent(metersF -> params.add("metersFrom", metersF.toString()));
        Optional.ofNullable(metersTo).ifPresent(metersT -> params.add("metersTo", metersT.toString()));

        OfferDto[] offers = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/offer")
                        .queryParams(params)
                        .build())
                .retrieve()
                .bodyToMono(OfferDto[].class)
                .block();

        return Arrays.stream(offers).toList();
    }

}
