package com.egg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.domain.model.Shed;
import com.egg.domain.repository.query.ShedRepositoryQuery;

public interface ShedRepository extends JpaRepository<Shed, Long>, ShedRepositoryQuery{

}
