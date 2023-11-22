package com.rea.system.offer.application.engine;

import com.rea.system.offer.application.engine.util.ServiceUrlConstant;
import com.rea.system.offer.application.engine.ports.input.InvokerEngineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvokerEngineServiceImpl implements InvokerEngineService {

    private final OfferProcessingService offerProcessingService;

    public void invoke() {
        Stream.of(ServiceUrlConstant.SELL_FLAT_DTO).forEach(offerProcessingService::process);
    }

}

