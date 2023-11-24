package com.rea.system.intent.domain.port.output.security;

import reactor.core.publisher.Mono;

public interface UserSecurityAuthenticationService {

    Mono<String> getUserId();

    Mono<String> getUsername();

}
