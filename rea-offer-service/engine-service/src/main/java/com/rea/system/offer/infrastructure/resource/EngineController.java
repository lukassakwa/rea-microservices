package com.rea.system.offer.infrastructure.resource;

import com.rea.system.offer.application.engine.ports.input.InvokerEngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/offer/engine")
@RequiredArgsConstructor
public class EngineController {

    private final InvokerEngineService invokerEngineService;

    @GetMapping()
    Mono<Void> invokeEngine() {
        invokerEngineService.invoke();
        return Mono.empty();
    }

}
