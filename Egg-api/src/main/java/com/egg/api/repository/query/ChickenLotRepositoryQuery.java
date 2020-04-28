package com.egg.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.ChickenLot;
import com.egg.api.repository.filter.ChickenLotFilter;

public interface ChickenLotRepositoryQuery  {
	
	public Page<ChickenLot> findByFilter(ChickenLotFilter chickenLotFilter, Pageable pageable);

}
