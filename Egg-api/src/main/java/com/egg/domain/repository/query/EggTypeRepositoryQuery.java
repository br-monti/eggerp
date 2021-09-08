package com.egg.domain.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.domain.model.EggType;
import com.egg.domain.repository.filter.EggTypeFilter;

public interface EggTypeRepositoryQuery  {
	
	public Page<EggType> findByFilter(EggTypeFilter eggTypeFilter, Pageable pageable);

}
