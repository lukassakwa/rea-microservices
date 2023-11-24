package com.rea.system.intent.domain.port.output.security;

import reactor.core.publisher.Mono;

public interface UserOfferSecurityAuthenticationService {

    Mono<String> getUserId();

}
