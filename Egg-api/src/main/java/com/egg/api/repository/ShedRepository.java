package com.egg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.api.model.Shed;
import com.egg.api.repository.query.ShedRepositoryQuery;

public interface ShedRepository extends JpaRepository<Shed, Long>, ShedRepositoryQuery{

}
