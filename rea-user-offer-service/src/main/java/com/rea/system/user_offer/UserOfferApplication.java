package com.rea.system.user_offer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class UserOfferApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserOfferApplication.class, args);
    }

}
