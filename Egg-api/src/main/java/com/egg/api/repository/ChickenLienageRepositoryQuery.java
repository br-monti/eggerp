package com.egg.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.ChickenLineage;
import com.egg.api.repository.filter.ChickenLineageFilter;

public interface ChickenLienageRepositoryQuery  {
	
	public Page<ChickenLineage> filtrar(ChickenLineageFilter lancamentoFilter, Pageable pageable);

}
