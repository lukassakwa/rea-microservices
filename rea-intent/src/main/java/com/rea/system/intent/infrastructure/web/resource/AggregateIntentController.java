package com.rea.system.intent.infrastructure.web.resource;

import com.rea.system.intent.domain.aggregate.AggregateIntentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rea.system.intent.infrastructure.web.model.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AggregateIntentController {

    private final AggregateIntentService aggregateIntentService;

    @GetMapping("/favorite")
    Flux<OfferIntentResponse> getOffers(@RequestParam EstateServiceType estateServiceType,
                                        @RequestParam String index) {
        return aggregateIntentService.getUserOffers(estateServiceType, Integer.valueOf(index));
    }

}
