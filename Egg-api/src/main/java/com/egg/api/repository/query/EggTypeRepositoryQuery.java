package com.egg.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.EggType;
import com.egg.api.repository.filter.EggTypeFilter;

public interface EggTypeRepositoryQuery  {
	
	public Page<EggType> findByFilter(EggTypeFilter eggTypeFilter, Pageable pageable);

}
