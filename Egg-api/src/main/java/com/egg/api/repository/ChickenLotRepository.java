package com.egg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.api.model.ChickenLot;
import com.egg.api.repository.query.ChickenLotRepositoryQuery;


public interface ChickenLotRepository extends JpaRepository<ChickenLot, Long>, ChickenLotRepositoryQuery {

}
