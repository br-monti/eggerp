package com.egg.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.api.model.Classification;
import com.egg.api.model.EggBase;
import com.egg.api.model.EggType;
import com.egg.api.repository.EggBaseRepository;
import com.egg.api.repository.EggTypeRepository;

@Service
public class EggBaseService {
	
	@Autowired
	private EggBaseRepository eggBaseRepository;
	
	@Autowired
	private EggTypeRepository eggTypeRepository;
	
	
	


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
		List <EggType> eggTypeList = eggTypeRepository.findAll();
		
		List <Classification> classificationList = new ArrayList<>();

		Classification classification = null;
		for (EggType eggType : eggTypeList) {
			classification = new Classification();
			classification.setEggBase(eggBase);	
			classification.setEggType(eggType);
			classificationList.add(classification);
		}		
		
		eggBase.setClassifications(classificationList);		
		
		return eggBaseRepository.save(eggBase);
	}

}
