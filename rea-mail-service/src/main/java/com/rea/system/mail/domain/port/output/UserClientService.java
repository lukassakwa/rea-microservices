package com.rea.system.mail.domain.port.output;

import com.rea.system.mail.domain.core.UserMailEntity;
import reactor.core.publisher.Flux;

public interface UserClientService {

    Flux<UserMailEntity> getUsers();

}
