package com.rea.system.offer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class OfferApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfferApplication.class, args);
    }

}
