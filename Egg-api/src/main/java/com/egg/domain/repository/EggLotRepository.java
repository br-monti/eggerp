package com.egg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.domain.model.EggLot;
import com.egg.domain.repository.query.EggLotRepositoryQuery;


public interface EggLotRepository extends JpaRepository<EggLot, Long>, EggLotRepositoryQuery {

}
