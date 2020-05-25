package com.egg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.api.model.Classification;
import com.egg.api.repository.query.ClassificationRepositoryQuery;

public interface ClassificationRepository extends JpaRepository<Classification, Long>, ClassificationRepositoryQuery {

}
