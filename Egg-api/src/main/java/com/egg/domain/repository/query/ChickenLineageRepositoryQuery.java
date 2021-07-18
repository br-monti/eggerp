package com.egg.domain.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.domain.model.ChickenLineage;
import com.egg.domain.repository.filter.ChickenLineageFilter;

public interface ChickenLineageRepositoryQuery  {
	
	public Page<ChickenLineage> findByFilter(ChickenLineageFilter chickenLineageFilter, Pageable pageable);

}
