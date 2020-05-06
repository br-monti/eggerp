package com.egg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.api.model.EggLot;
import com.egg.api.repository.query.EggLotRepositoryQuery;


public interface EggLotRepository extends JpaRepository<EggLot, Long>, EggLotRepositoryQuery {

}
