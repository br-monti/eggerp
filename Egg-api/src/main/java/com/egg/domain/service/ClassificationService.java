package com.egg.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.domain.model.Classification;
import com.egg.domain.model.EggBase;
import com.egg.domain.model.EggType;
import com.egg.domain.repository.ClassificationRepository;
import com.egg.domain.repository.EggBaseRepository;
import com.egg.domain.repository.EggTypeRepository;

@Service
public class ClassificationService {
	
	@Autowired
	private ClassificationRepository classificationRepository;
	
	@Autowired
	private EggTypeRepository eggTypeRepository;
	
	@Autowired
	private EggBaseService eggBaseService;

	public Classification update(Long id, Classification classification) {
		Classification classificationSaved = findClassificationById(id);
		
		//classificationSaved.getChickenLots().clear();
		//classificationSaved.getChickenLots().addAll(classification.getChickenLots());		
		//classificationSaved.getChickenLots().forEach(c -> c.setClassification(classificationSaved));
		
		BeanUtils.copyProperties(classification, classificationSaved, "id");
		return classificationRepository.save(classificationSaved);
	}

	
	public Classification findClassificationById(Long id) {
		Classification classificationSaved = classificationRepository.findById(id).orElse(null);
		if (classificationSaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return classificationSaved;
	}
	
	public Classification save(Classification classification) {
		//classification.getChickenLots().forEach(c -> c.setClassification(classification));
		return classificationRepository.save(classification);
	}
	
	public void saveClassificationsByEggType() {
		
	}
	
	public void createClassifications(Long id) {			
		
		EggBase eggBase = eggBaseService.findEggBaseById(id);
		List <EggType> eggTypeList = eggTypeRepository.findAll();
		
		eggTypeList.forEach(e -> {			
			
			Classification classification = new Classification();
			classification.setEggBase(eggBase);	
			classification.setEggType(e);			
			classificationRepository.save(classification);
		});
				
	}

}
