package com.egg.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.Classification;
import com.egg.api.repository.filter.ClassificationFilter;

public interface ClassificationRepositoryQuery  {
	
	public Page<Classification> findByFilter(ClassificationFilter classificationFilter, Pageable pageable);

}
