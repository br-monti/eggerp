package com.egg.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.EggBase;
import com.egg.api.repository.filter.EggBaseFilter;
import com.egg.api.repository.projection.EggBaseResume;

public interface EggBaseRepositoryQuery  {
	
	public Page<EggBase> findByFilter(EggBaseFilter eggBaseFilter, Pageable pageable);
	public Page<EggBaseResume> resume(EggBaseFilter eggBaseFilter, Pageable pageable);

}
