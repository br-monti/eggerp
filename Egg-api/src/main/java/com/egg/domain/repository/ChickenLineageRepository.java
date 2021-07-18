package com.egg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.domain.model.ChickenLineage;
import com.egg.domain.repository.query.ChickenLineageRepositoryQuery;


public interface ChickenLineageRepository extends JpaRepository<ChickenLineage, Long>, ChickenLineageRepositoryQuery {

}
