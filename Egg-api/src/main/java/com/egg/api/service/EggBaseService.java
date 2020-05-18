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
		
		//eggBaseSaved.getChickenLots().clear();
		//eggBaseSaved.getChickenLots().addAll(eggBase.getChickenLots());		
		//eggBaseSaved.getChickenLots().forEach(c -> c.setEggBase(eggBaseSaved));
		
		BeanUtils.copyProperties(eggBase, eggBaseSaved, "id");
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
		//eggBase.getChickenLots().forEach(c -> c.setEggBase(eggBase));
		return eggBaseRepository.save(eggBase);
	}

}
