package com.egg.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.api.model.ShedManufacturer;
import com.egg.api.repository.ShedManufacturerRepository;

@Service
public class ShedManufacturerService {
	
	@Autowired
	private ShedManufacturerRepository shedManufacturerRepository;

	public ShedManufacturer update(Long id, ShedManufacturer shedManufacurer) {
		ShedManufacturer shedManufacurerSaved = findShedManufacturerById(id);
		
		BeanUtils.copyProperties(shedManufacurer, shedManufacurerSaved, "id");
		return shedManufacturerRepository.save(shedManufacurerSaved);
	}

	
	public ShedManufacturer findShedManufacturerById(Long id) {
		ShedManufacturer shedManufacturerSaved = shedManufacturerRepository.findById(id).orElse(null);
		if (shedManufacturerSaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return shedManufacturerSaved;
	}

}
