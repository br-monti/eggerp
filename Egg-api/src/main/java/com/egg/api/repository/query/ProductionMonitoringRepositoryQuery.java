package com.egg.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.ProductionMonitoring;
import com.egg.api.repository.filter.ProductionMonitoringFilter;

public interface ProductionMonitoringRepositoryQuery  {
	
	public Page<ProductionMonitoring> findByFilter(ProductionMonitoringFilter productionMonitoringFilter, Pageable pageable);

}
