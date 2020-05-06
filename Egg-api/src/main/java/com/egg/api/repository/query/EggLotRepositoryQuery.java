package com.egg.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.EggLot;
import com.egg.api.repository.filter.EggLotFilter;

public interface EggLotRepositoryQuery  {
	
	public Page<EggLot> findByFilter(EggLotFilter eggLotFilter, Pageable pageable);

}
