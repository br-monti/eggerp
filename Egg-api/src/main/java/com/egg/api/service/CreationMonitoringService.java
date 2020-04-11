package com.egg.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.api.model.CreationMonitoring;
import com.egg.api.repository.CreationMonitoringRepository;

@Service
public class CreationMonitoringService {
	
	@Autowired
	private CreationMonitoringRepository creationMonitoringRepository;

	public CreationMonitoring update(Long id, CreationMonitoring creationMonitoring) {
		CreationMonitoring creationMonitoringSaved = findCreationMonitoringById(id);
		
		BeanUtils.copyProperties(creationMonitoring, creationMonitoringSaved, "id");
		return creationMonitoringRepository.save(creationMonitoringSaved);
	}

	
	public CreationMonitoring findCreationMonitoringById(Long id) {
		CreationMonitoring creationMonitoringSaved = creationMonitoringRepository.findById(id).orElse(null);
		if (creationMonitoringSaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return creationMonitoringSaved;
	}

}
