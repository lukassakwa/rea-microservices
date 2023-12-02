package com.rea.system.offer.infrastructure.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.SslProvider;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfiguration {

    private static final int BUFFER_SIZE_16MB = 16 * 1024 * 1024;

    @Bean
    WebClient webClient() {
        return WebClient.builder()
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
                .secure(spec -> spec.sslContext(SslContextBuilder.forClient())
                        .defaultConfiguration(SslProvider.DefaultConfigurationType.TCP)
                        .handshakeTimeout(Duration.ofSeconds(20))
                        .closeNotifyFlushTimeout(Duration.ofSeconds(20))
                        .closeNotifyReadTimeout(Duration.ofSeconds(20)))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(20))
                                .addHandlerLast(new WriteTimeoutHandler(20)));
    }


}
