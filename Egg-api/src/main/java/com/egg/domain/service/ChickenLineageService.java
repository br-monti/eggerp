package com.egg.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.domain.model.ChickenLineage;
import com.egg.domain.repository.ChickenLineageRepository;

@Service
public class ChickenLineageService {	

	@Autowired
	private ChickenLineageRepository chickenLineageRepository;

	public ChickenLineage update(Long id, ChickenLineage chickenLineage) {
		ChickenLineage chickenLineageSaved = findChickenLineageById(id);
		
		BeanUtils.copyProperties(chickenLineage, chickenLineageSaved, "id");
		return chickenLineageRepository.save(chickenLineageSaved);
	}

	
	public ChickenLineage findChickenLineageById(Long id) {
		ChickenLineage chickenLineageSaved = chickenLineageRepository.findById(id).orElse(null);
		if (chickenLineageSaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return chickenLineageSaved;
	}

}
