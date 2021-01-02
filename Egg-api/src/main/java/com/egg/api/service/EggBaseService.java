package com.egg.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.api.model.EggBase;
import com.egg.api.repository.EggBaseRepository;

@Service
public class EggBaseService {
	
	@Autowired
	private EggBaseRepository eggBaseRepository;

	public EggBase update(Long id, EggBase eggBase) {
		EggBase eggBaseSaved = findEggBaseById(id);
		
		eggBaseSaved.getClassifications().clear();
		eggBaseSaved.getClassifications().addAll(eggBase.getClassifications());		
		eggBaseSaved.getClassifications().forEach(c -> c.setEggBase(eggBaseSaved));
		
		BeanUtils.copyProperties(eggBase, eggBaseSaved, "id", "classifications");
		return eggBaseRepository.save(eggBaseSaved);
	}

	
	public EggBase findEggBaseById(Long id) {
		EggBase eggBaseSaved = eggBaseRepository.findById(id).orElse(null);
		if (eggBaseSaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return eggBaseSaved;
	}


	public EggBase save(EggBase eggBase) {
		eggBase.getClassifications().forEach(c -> c.setEggBase(eggBase));
		return eggBaseRepository.save(eggBase);
	}
	
	
//	List <EggType> eggTypeList = eggTypeRepository.findAll();
//	int index = 0;
//	
//	for (Classification classification : eggBase.getClassifications()) {
//		classification.setEggBase(eggBase);			
//		classification.setEggType(eggTypeList.get(index));
//		index++;
//	}
//	index = 0;

}
