package com.rea.system.offer.infrastructure.dataaccess.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@NoRepositoryBean
public interface OfferRepository<T, ID> extends MongoRepository<T, ID>, QuerydslPredicateExecutor<T> {

    Optional<T> findByDuplicateKey(String duplicateKey);

    List<T> findAllByIdIn(Set<String> ids);

}
