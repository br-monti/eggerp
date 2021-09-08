package com.egg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.domain.model.Packing;
import com.egg.domain.repository.query.PackingRepositoryQuery;

public interface PackingRepository extends JpaRepository<Packing, Long>, PackingRepositoryQuery {

}
