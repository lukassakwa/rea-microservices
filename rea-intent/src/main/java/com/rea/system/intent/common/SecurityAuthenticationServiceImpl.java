package com.rea.system.intent.common;

import com.rea.system.intent.user.UserSecurityAuthenticationService;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SecurityAuthenticationServiceImpl implements UserSecurityAuthenticationService {

    private static final String USERNAME = "email";

    private Mono<JwtAuthenticationToken> getUserDetails() {
        return ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .cast(JwtAuthenticationToken.class);
    }

    @Override
    public Mono<String> getUserId() {
        return getUserDetails().map(JwtAuthenticationToken::getName);
    }

    @Override
    public Mono<String> getUsername() {
        return getUserDetails()
                .map(JwtAuthenticationToken::getTokenAttributes)
                .map(details -> details.get(USERNAME).toString());
    }
}
