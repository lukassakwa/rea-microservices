package com.rea.system.aggregate.infrastructure.web.resource.mail;

import com.rea.system.aggregate.domain.mail.DomainMailUserOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rea.system.aggregate.infrastructure.web.model.MailUserOfferAggregateResponse;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/mail/aggregate")
@RequiredArgsConstructor
public class UserOfferMailController {

    private final DomainMailUserOfferService domainMailUserOfferService;
    private final MailResponseMapper mailResponseMapper;

    @GetMapping()
    Flux<MailUserOfferAggregateResponse> getUsersWithOfferToSend() {
        return domainMailUserOfferService.mailUserOfferAggregate()
                .map(mailResponseMapper::toResponse);
    }

}
