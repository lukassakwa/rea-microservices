package com.rea.system.offer.infrastructure.dataaccess.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import reactor.core.publisher.Flux;

@NoRepositoryBean
public interface HistoricalOfferRepository<T, ID> extends ReactiveMongoRepository<T, ID>, ReactiveQuerydslPredicateExecutor<T> {

    Flux<T> findAllByPublicId(String publicId);

}
