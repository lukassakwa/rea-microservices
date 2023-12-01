package com.rea.system.mail.domain;

import com.rea.system.mail.domain.port.output.AggregateClientService;
import com.rea.system.mail.domain.port.output.MailClientService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DomainMailService {

    private static final String NEWEST_MAIL_TITLE = "Newest Rea Offers";

    private final AggregateClientService aggregateClientService;
    private final MailClientService mailClientService;

    @SneakyThrows
    public void sendEmailToUser() {
        aggregateClientService.getAggregateUserOffers()
                .subscribe(mailEntity -> {
                    mailClientService.sendMail(
                            mailEntity.getUsername(),
                            NEWEST_MAIL_TITLE,
                            mailEntity.offerContent(),
                            true
                    );
                });
    }

}
