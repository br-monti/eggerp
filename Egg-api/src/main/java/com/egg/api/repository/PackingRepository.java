package com.egg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.api.model.Packing;
import com.egg.api.repository.query.PackingRepositoryQuery;

public interface PackingRepository extends JpaRepository<Packing, Long>, PackingRepositoryQuery {

}
