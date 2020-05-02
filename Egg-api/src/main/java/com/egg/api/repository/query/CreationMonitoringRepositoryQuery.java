package com.egg.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.CreationMonitoring;
import com.egg.api.repository.filter.CreationMonitoringFilter;

public interface CreationMonitoringRepositoryQuery  {
	
	public Page<CreationMonitoring> findByFilter(CreationMonitoringFilter creationMonitoringFilter, Pageable pageable);

}
