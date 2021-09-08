package com.egg.domain.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.domain.model.ProductionMonitoring;
import com.egg.domain.repository.filter.ProductionMonitoringFilter;

public interface ProductionMonitoringRepositoryQuery  {
	
	public Page<ProductionMonitoring> findByFilter(ProductionMonitoringFilter productionMonitoringFilter, Pageable pageable);

}
