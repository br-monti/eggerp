package com.egg.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.EggBase;
import com.egg.api.repository.filter.EggBaseFilter;

public interface EggBaseRepositoryQuery  {
	
	public Page<EggBase> findByFilter(EggBaseFilter eggBaseFilter, Pageable pageable);

}
