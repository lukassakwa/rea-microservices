package com.rea.system.intent.user;

import reactor.core.publisher.Mono;

public interface UserSecurityAuthenticationService {

    Mono<String> getUserId();

    Mono<String> getUsername();

}
