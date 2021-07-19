package com.egg.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.domain.exception.ChickenLineageNotFoundException;
import com.egg.domain.exception.EntityInUseException;
import com.egg.domain.model.ChickenLineage;
import com.egg.domain.repository.ChickenLineageRepository;

@Service
public class ChickenLineageService {	

//	@Autowired
//	private ChickenLineageRepository chickenLineageRepository;
//
//	public ChickenLineage update(Long id, ChickenLineage chickenLineage) {
//		ChickenLineage chickenLineageSaved = findChickenLineageById(id);
//		
//		BeanUtils.copyProperties(chickenLineage, chickenLineageSaved, "id");
//		return chickenLineageRepository.save(chickenLineageSaved);
//	}
//
//	
//	public ChickenLineage findChickenLineageById(Long id) {
//		ChickenLineage chickenLineageSaved = chickenLineageRepository.findById(id).orElse(null);
//		if (chickenLineageSaved == null) {
//			throw new EmptyResultDataAccessException(1);
//		}
//		return chickenLineageSaved;
//	}
	
	private static final String MSG_CHICKEN_LINEAGE_IN_USE
	= "Linhagem de Aves de código %d não pode ser removida, pois está em uso";

	@Autowired
	private ChickenLineageRepository chickenLineageRepository;
	
	@Transactional
	public ChickenLineage save(ChickenLineage chickenLineage) {
		return chickenLineageRepository.save(chickenLineage);
	}
	
	@Transactional
	public void delete(Long chickenLineageId) {
		try {
			chickenLineageRepository.deleteById(chickenLineageId);
			chickenLineageRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new ChickenLineageNotFoundException(chickenLineageId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(
				String.format(MSG_CHICKEN_LINEAGE_IN_USE, chickenLineageId));
		}
	}
	
	public ChickenLineage find(Long cozinhaId) {
		return chickenLineageRepository.findById(cozinhaId)
			.orElseThrow(() -> new ChickenLineageNotFoundException(cozinhaId));
	}
	
	

}
