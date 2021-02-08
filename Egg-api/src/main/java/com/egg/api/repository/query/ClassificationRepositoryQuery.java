package com.egg.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.Classification;
import com.egg.api.repository.filter.ClassificationFilter;
import com.egg.api.repository.projection.ClassificationResume;

public interface ClassificationRepositoryQuery  {
	
	public Page<Classification> findByFilter(ClassificationFilter classificationFilter, Pageable pageable);
	public Page<ClassificationResume> resume(ClassificationFilter classificationFilter, Pageable pageable);

}
