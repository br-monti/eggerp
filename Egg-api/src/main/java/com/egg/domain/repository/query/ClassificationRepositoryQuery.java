package com.egg.domain.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.domain.model.Classification;
import com.egg.domain.repository.filter.ClassificationFilter;
import com.egg.domain.repository.projection.ClassificationResume;

public interface ClassificationRepositoryQuery  {
	
	public Page<Classification> findByFilter(ClassificationFilter classificationFilter, Pageable pageable);
	public Page<ClassificationResume> resume(ClassificationFilter classificationFilter, Pageable pageable);

}
