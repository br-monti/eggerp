package com.egg.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.domain.model.EggLot;
import com.egg.domain.repository.EggLotRepository;

@Service
public class EggLotService {
	
	@Autowired
	private EggLotRepository eggLotRepository;

	public EggLot update(Long id, EggLot eggLot) {
		EggLot eggLotSaved = findEggLotById(id);
		
		//eggLotSaved.getChickenLots().clear();
		//eggLotSaved.getChickenLots().addAll(eggLot.getChickenLots());		
		//eggLotSaved.getChickenLots().forEach(c -> c.setEggLot(eggLotSaved));
		
		BeanUtils.copyProperties(eggLot, eggLotSaved, "id", "chickenLots");
		return eggLotRepository.save(eggLotSaved);
	}

	
	public EggLot findEggLotById(Long id) {
		EggLot eggLotSaved = eggLotRepository.findById(id).orElse(null);
		if (eggLotSaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return eggLotSaved;
	}


	public EggLot save(EggLot eggLot) {
		//eggLot.getChickenLots().forEach(c -> c.setEggLot(eggLot));
		return eggLotRepository.save(eggLot);
	}

}
