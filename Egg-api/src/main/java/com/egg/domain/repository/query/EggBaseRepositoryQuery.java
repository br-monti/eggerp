package com.egg.domain.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.domain.model.EggBase;
import com.egg.domain.repository.filter.EggBaseFilter;
import com.egg.domain.repository.projection.EggBaseResume;

public interface EggBaseRepositoryQuery  {
	
	public Page<EggBase> findByFilter(EggBaseFilter eggBaseFilter, Pageable pageable);
	public Page<EggBaseResume> resume(EggBaseFilter eggBaseFilter, Pageable pageable);

}
