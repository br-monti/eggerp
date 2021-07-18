package com.egg.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.domain.model.Packing;
import com.egg.domain.repository.PackingRepository;

@Service
public class PackingService {
	
	@Autowired
	private PackingRepository packingRepository;

	public Packing update(Long id, Packing packing) {
		Packing packingSaved = findPackingById(id);
		
		//packingSaved.getChickenLots().clear();
		//packingSaved.getChickenLots().addAll(packing.getChickenLots());		
		//packingSaved.getChickenLots().forEach(c -> c.setPacking(packingSaved));
		
		BeanUtils.copyProperties(packing, packingSaved, "id");
		return packingRepository.save(packingSaved);
	}

	
	public Packing findPackingById(Long id) {
		Packing packingSaved = packingRepository.findById(id).orElse(null);
		if (packingSaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return packingSaved;
	}


	public Packing save(Packing packing) {
		//packing.getChickenLots().forEach(c -> c.setPacking(packing));
		return packingRepository.save(packing);
	}

}
