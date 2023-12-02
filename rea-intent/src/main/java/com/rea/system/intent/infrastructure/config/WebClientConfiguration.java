package com.rea.system.intent.infrastructure.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class WebClientConfiguration {

    private static final int BUFFER_SIZE_16MB = 16 * 1024 * 1024;

    private final String aggregateServiceUrl;
    private final String offerServiceUrl;
    private final String userServiceUrl;
    private final String engineServiceUrl;
    private final String mailServiceUrl;

    public WebClientConfiguration(
            @Value(value = "${microservices.url.aggregate-service}") String aggregateServiceUrl,
            @Value(value = "${microservices.url.offer-service}") String offerServiceUrl,
            @Value(value = "${microservices.url.user-service}") String userServiceUrl,
            @Value(value = "${microservices.url.engine-service}") String engineServiceUrl,
            @Value(value = "${microservices.url.mail-service}") String mailServiceUrl
    ) {
        this.aggregateServiceUrl = aggregateServiceUrl;
        this.offerServiceUrl = offerServiceUrl;
        this.userServiceUrl = userServiceUrl;
        this.engineServiceUrl = engineServiceUrl;
        this.mailServiceUrl = mailServiceUrl;
    }

    @Bean(name = "userClient")
    WebClient userClient() {
        return webClient(userServiceUrl);
    }

    @Bean(name = "aggregateClient")
    WebClient aggregateClient() {
        return webClient(aggregateServiceUrl);
    }

    @Bean(name = "offerClient")
    WebClient offerClient() {
        return webClient(offerServiceUrl);
    }

    @Bean(name = "offerEngineClient")
    WebClient offerEngineClient() {
        return webClient(engineServiceUrl);
    }

    @Bean(name = "mailClient")
    WebClient mailClient() {
        return webClient(mailServiceUrl);
    }

    WebClient webClient(String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .exchangeStrategies(ExchangeStrategies.builder().codecs(this::acceptedCodecs).build())
                .clientConnector(new ReactorClientHttpConnector(create()))
                .build();
    }

    private void acceptedCodecs(ClientCodecConfigurer clientCodecConfigurer) {
        clientCodecConfigurer.defaultCodecs().maxInMemorySize(BUFFER_SIZE_16MB);
    }

    private HttpClient create() {
        return HttpClient.create()
                .followRedirect(true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 20000)
                .responseTimeout(Duration.ofMillis(20000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(20))
                                .addHandlerLast(new WriteTimeoutHandler(20)));
    }


}
