package com.egg.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.api.model.EggType;
import com.egg.api.repository.EggTypeRepository;

@Service
public class EggTypeService {
	
	@Autowired
	private EggTypeRepository eggTypeRepository;

	public EggType update(Long id, EggType eggType) {
		EggType eggTypeSaved = findEggTypeById(id);
		BeanUtils.copyProperties(eggType, eggTypeSaved, "id");
		return eggTypeRepository.save(eggTypeSaved);
	}

	
	public EggType findEggTypeById(Long id) {
		EggType eggTypeSaved = eggTypeRepository.findById(id).orElse(null);
		if (eggTypeSaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return eggTypeSaved;
	}


	public EggType save(EggType eggType) {
		return eggTypeRepository.save(eggType);
	}

}
