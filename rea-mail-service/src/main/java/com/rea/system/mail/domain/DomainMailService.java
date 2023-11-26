package com.rea.system.mail.domain;

import com.rea.system.mail.domain.core.MailEntity;
import com.rea.system.mail.domain.core.OfferMailEntity;
import com.rea.system.mail.domain.port.output.MailClientService;
import com.rea.system.mail.domain.port.output.OfferClientService;
import com.rea.system.mail.domain.port.output.UserClientService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainMailService {

    private static final String NEWEST_MAIL_TITLE = "Newest Rea Offers";

    private final OfferClientService offerClientService;
    private final UserClientService userClientService;
    private final MailClientService mailClientService;
    private final MailMapper mapper;

    @SneakyThrows
    public void sendEmailToUser() {
        userClientService.getUsers()
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(userMailEntity -> {
                    LinkedMultiValueMap<String, String> query = userMailEntity.buildQueryParams();
                    Mono<List<OfferMailEntity>> offerMails = offerClientService.getOffers(query)
                            .take(10, true)
                            .collectList();
                    return offerMails.map(offerEntities -> mapper.toEntity(offerEntities, userMailEntity));
                })
                .subscribe(this::sendMail);

    }

    private void sendMail(MailEntity mailEntity) {
        mailClientService.sendMail(
                mailEntity.getUsername(),
                NEWEST_MAIL_TITLE,
                mailEntity.offerContent(),
                true
        );
    }

}
