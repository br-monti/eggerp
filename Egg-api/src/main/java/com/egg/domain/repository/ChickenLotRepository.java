package com.egg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.domain.model.ChickenLot;
import com.egg.domain.repository.query.ChickenLotRepositoryQuery;


public interface ChickenLotRepository extends JpaRepository<ChickenLot, Long>, ChickenLotRepositoryQuery {

}
