package com.rea.system.aggregate.domain.mail;

import com.rea.system.aggregate.domain.mail.core.MailUserOfferEntity;
import com.rea.system.aggregate.domain.mail.core.OfferMailEntity;
import com.rea.system.aggregate.domain.mail.port.output.MailOfferClientService;
import com.rea.system.aggregate.domain.mail.port.output.MailUserClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainMailUserOfferService {

    private final MailOfferClientService mailOfferClientService;
    private final MailUserClientService mailUserClientService;
    private final DomainMailUserOfferMapper mapper;

    public Flux<MailUserOfferEntity> mailUserOfferAggregate() {
        return mailUserClientService.getUsers()
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(userMailEntity -> {
                    LinkedMultiValueMap<String, String> query = userMailEntity.buildQueryParams();
                    Mono<List<OfferMailEntity>> offerMails = mailOfferClientService.getOffers(query)
                            .take(10, true)
                            .collectList();
                    return offerMails.map(offerEntities -> mapper.toEntity(offerEntities, userMailEntity));
                });
    }

}
