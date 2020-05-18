package com.egg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.api.model.EggBase;
import com.egg.api.repository.query.EggBaseRepositoryQuery;

public interface EggBaseRepository extends JpaRepository<EggBase, Long>, EggBaseRepositoryQuery {

}
