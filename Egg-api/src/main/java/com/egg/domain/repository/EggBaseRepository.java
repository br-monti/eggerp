package com.egg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.domain.model.EggBase;
import com.egg.domain.repository.query.EggBaseRepositoryQuery;

public interface EggBaseRepository extends JpaRepository<EggBase, Long>, EggBaseRepositoryQuery {

}
