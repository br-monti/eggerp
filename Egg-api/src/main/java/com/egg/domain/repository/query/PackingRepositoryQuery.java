package com.egg.domain.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.domain.model.Packing;
import com.egg.domain.repository.filter.PackingFilter;

public interface PackingRepositoryQuery  {
	
	public Page<Packing> findByFilter(PackingFilter packingFilter, Pageable pageable);

}
