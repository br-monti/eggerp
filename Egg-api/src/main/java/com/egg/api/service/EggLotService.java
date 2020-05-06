package com.egg.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.api.model.EggLot;
import com.egg.api.repository.EggLotRepository;

@Service
public class EggLotService {
	
	@Autowired
	private EggLotRepository eggLotRepository;

	public EggLot update(Long id, EggLot eggLot) {
		EggLot eggLotSaved = findEggLotById(id);
		
		BeanUtils.copyProperties(eggLot, eggLotSaved, "id");
		return eggLotRepository.save(eggLotSaved);
	}

	
	public EggLot findEggLotById(Long id) {
		EggLot eggLotSaved = eggLotRepository.findById(id).orElse(null);
		if (eggLotSaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return eggLotSaved;
	}

}
