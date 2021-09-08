package com.egg.domain.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.domain.model.CreationMonitoring;
import com.egg.domain.repository.filter.CreationMonitoringFilter;

public interface CreationMonitoringRepositoryQuery  {
	
	public Page<CreationMonitoring> findByFilter(CreationMonitoringFilter creationMonitoringFilter, Pageable pageable);

}
