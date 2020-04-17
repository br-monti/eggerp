package com.egg.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.ChickenLineage;
import com.egg.api.repository.filter.ChickenLineageFilter;

public class ChickenLineageReepositoryImpl implements ChickenLienageRepositoryQuery {

	@Override
	public Page<ChickenLineage> filtrar(ChickenLineageFilter lancamentoFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
