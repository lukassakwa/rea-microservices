package com.rea.system.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
public class WebClientConfiguration {

    private static final int BUFFER_SIZE_16MB = 16 * 1024 * 1024;

    @Bean
    WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080")
                .exchangeStrategies(ExchangeStrategies.builder().codecs(this::acceptedCodecs).build())
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create()))
                .build();
    }

    private void acceptedCodecs(ClientCodecConfigurer clientCodecConfigurer) {
        clientCodecConfigurer.defaultCodecs().maxInMemorySize(BUFFER_SIZE_16MB);
    }


}
