package com.rea.system.offer.infrastructure.dataaccess.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@NoRepositoryBean
public interface OfferRepository<T, ID> extends ReactiveMongoRepository<T, ID>, ReactiveQuerydslPredicateExecutor<T> {

    Mono<T> findByDuplicateKey(String duplicateKey);

    Flux<T> findAllByIdIn(Set<String> ids);

}
