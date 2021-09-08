package com.egg.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.domain.model.ProductionMonitoring;
import com.egg.domain.repository.ProductionMonitoringRepository;

@Service
public class ProductionMonitoringService {
	
	@Autowired
	private ProductionMonitoringRepository productionMonitoringRepository;

	public ProductionMonitoring update(Long id, ProductionMonitoring productionMonitoring) {
		ProductionMonitoring productionMonitoringSaved = findProductionMonitoringById(id);
		
		BeanUtils.copyProperties(productionMonitoring, productionMonitoringSaved, "id");
		return productionMonitoringRepository.save(productionMonitoringSaved);
	}

	
	public ProductionMonitoring findProductionMonitoringById(Long id) {
		ProductionMonitoring productionMonitoringSaved = productionMonitoringRepository.findById(id).orElse(null);
		if (productionMonitoringSaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return productionMonitoringSaved;
	}

}
