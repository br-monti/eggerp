package com.egg.domain.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.domain.model.Shed;
import com.egg.domain.repository.filter.ShedFilter;

public interface ShedRepositoryQuery  {
	
	public Page<Shed> findByFilter(ShedFilter shedFilter, Pageable pageable);

}
