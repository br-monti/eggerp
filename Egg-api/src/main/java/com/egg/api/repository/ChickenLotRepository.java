package com.egg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.api.model.ChickenLot;


public interface ChickenLotRepository extends JpaRepository<ChickenLot, Long> {

}
