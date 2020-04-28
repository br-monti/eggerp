package com.egg.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.Shed;
import com.egg.api.repository.filter.ShedFilter;

public interface ShedRepositoryQuery  {
	
	public Page<Shed> findByFilter(ShedFilter shedFilter, Pageable pageable);

}
