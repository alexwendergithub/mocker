package com.projects.mocker.repository;

import com.projects.mocker.model.MockEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockRepository extends MongoRepository<MockEntity, String> {
}