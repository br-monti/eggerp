package com.egg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.api.model.EggType;
import com.egg.api.repository.query.EggTypeRepositoryQuery;


public interface EggTypeRepository extends JpaRepository<EggType, Long>, EggTypeRepositoryQuery {

}
