package com.rea.system.intent.domain.user;

import com.rea.system.intent.domain.port.output.client.UserClientService;
import com.rea.system.intent.domain.port.output.security.UserSecurityAuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rea.system.common.intent.user.UserIntentPayload;
import rea.system.common.intent.user.UserIntentResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserIntentService {

    private final UserClientService userClientService;
    private final UserIntentMapper userIntentMapper;
    private final UserSecurityAuthenticationService securityAuthenticationService;

    public Mono<UserIntentResponse> getUser() {
        return securityAuthenticationService.getUserId()
                .flatMap(userClientService::getUserIntentResponse);
    }

    public Mono<UserIntentResponse> updateUser(UserIntentPayload payload) {
        Mono<String> userId = securityAuthenticationService.getUserId();
        Mono<String> username = securityAuthenticationService.getUsername();
        return Mono.zip(userId, username)
                .map(tuple -> userIntentMapper.update(
                        tuple.getT1(),
                        tuple.getT2(),
                        payload)
                )
                .flatMap(userClientService::updateUserClient);
    }


}
