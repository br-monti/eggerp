package com.egg.domain.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.domain.model.EggLot;
import com.egg.domain.repository.filter.EggLotFilter;

public interface EggLotRepositoryQuery  {
	
	public Page<EggLot> findByFilter(EggLotFilter eggLotFilter, Pageable pageable);

}
