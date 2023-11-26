package com.rea.system.aggregate.domain.mail.port.output;

import com.rea.system.aggregate.domain.mail.core.UserMailEntity;
import reactor.core.publisher.Flux;

public interface MailUserClientService {

    Flux<UserMailEntity> getUsers();

}
