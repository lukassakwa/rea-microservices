package com.rea.system.offer.infrastructure.dataaccess.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface HistoricalOfferRepository<T, ID> extends MongoRepository<T, ID>, QuerydslPredicateExecutor<T> {

    List<T> findAllByPublicId(String publicId);

}
