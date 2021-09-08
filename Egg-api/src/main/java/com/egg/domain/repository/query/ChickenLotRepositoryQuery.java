package com.egg.domain.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.domain.model.ChickenLot;
import com.egg.domain.repository.filter.ChickenLotFilter;

public interface ChickenLotRepositoryQuery  {
	
	public Page<ChickenLot> findByFilter(ChickenLotFilter chickenLotFilter, Pageable pageable);

}
