package com.egg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.api.model.ChickenLineage;
import com.egg.api.repository.query.ChickenLineageRepositoryQuery;


public interface ChickenLineageRepository extends JpaRepository<ChickenLineage, Long>, ChickenLineageRepositoryQuery {

}
