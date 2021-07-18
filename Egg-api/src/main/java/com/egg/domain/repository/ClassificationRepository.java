package com.egg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.domain.model.Classification;
import com.egg.domain.repository.query.ClassificationRepositoryQuery;

public interface ClassificationRepository extends JpaRepository<Classification, Long>, ClassificationRepositoryQuery {

}
