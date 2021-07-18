package com.egg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.domain.model.EggType;
import com.egg.domain.repository.query.EggTypeRepositoryQuery;


public interface EggTypeRepository extends JpaRepository<EggType, Long>, EggTypeRepositoryQuery {

}
