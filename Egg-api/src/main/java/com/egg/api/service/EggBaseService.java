package com.egg.api.service;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
		
		BeanUtils.copyProperties(eggBase, eggBaseSaved, "id", "classifications");
		eggBaseSaved.getClassifications().forEach(c -> {
			c.setEggBase(eggBaseSaved);
			
			if(c.getEggType().getType().equals("Descarte")) {
				eggBaseSaved.setDiscard(c.getQuantity());
			}
			
			if(c.getEggType().getType().equals("Industrial")) {
				eggBaseSaved.setCategoryB(c.getQuantity());
			}
						
		});
		
	    eggBaseSaved.setCategoryA(eggBaseSaved.getQuantity() - eggBaseSaved.getCategoryB() - eggBaseSaved.getDiscard());

		return eggBaseRepository.save(eggBaseSaved);
	}
	
	public void copyProperties(Object src, Object trg, Set<String> props) {
	    String[] excludedProperties = 
	            Arrays.stream(BeanUtils.getPropertyDescriptors(src.getClass()))
	                  .map(PropertyDescriptor::getName)
	                  .filter(name -> !props.contains(name))
	                  .toArray(String[]::new);

	    BeanUtils.copyProperties(src, trg, excludedProperties);
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
		
		eggTypeList.forEach(e -> {
			Classification classification = new Classification();
			classification.setEggBase(eggBase);	
			classification.setEggType(e);
			classificationList.add(classification);
		});
		
		eggBase.setClassifications(classificationList);		
		
		return eggBaseRepository.save(eggBase);
	}

}
