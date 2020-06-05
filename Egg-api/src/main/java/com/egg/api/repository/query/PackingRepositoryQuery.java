package com.egg.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.Packing;
import com.egg.api.repository.filter.PackingFilter;

public interface PackingRepositoryQuery  {
	
	public Page<Packing> findByFilter(PackingFilter packingFilter, Pageable pageable);

}
