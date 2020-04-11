package com.egg.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.api.model.Shed;
import com.egg.api.repository.ShedRepository;

@Service
public class ShedService {

	@Autowired
	private ShedRepository shedRepository;

	public Shed update(Long id, Shed shed) {
		Shed shedSaved = findShedById(id);
		
		BeanUtils.copyProperties(shed, shedSaved, "id");
		return shedRepository.save(shedSaved);
	}

	
	public Shed findShedById(Long id) {
		Shed shedSaved = shedRepository.findById(id).orElse(null);
		if (shedSaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return shedSaved;
	}
}
