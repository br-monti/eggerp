package com.egg.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.domain.model.ChickenLot;
import com.egg.domain.repository.ChickenLotRepository;

@Service
public class ChickenLotService {
	
	@Autowired
	private ChickenLotRepository chickenLotRepository;

	public ChickenLot update(Long id, ChickenLot chickenLot) {
		ChickenLot chickenLotSaved = findChickenLotById(id);
		
		BeanUtils.copyProperties(chickenLot, chickenLotSaved, "id");
		return chickenLotRepository.save(chickenLotSaved);
	}

	
	public ChickenLot findChickenLotById(Long id) {
		ChickenLot chickenLotSaved = chickenLotRepository.findById(id).orElse(null);
		if (chickenLotSaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return chickenLotSaved;
	}

}
