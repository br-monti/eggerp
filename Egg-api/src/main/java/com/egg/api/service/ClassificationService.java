package com.egg.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.egg.api.model.Classification;
import com.egg.api.model.EggType;
import com.egg.api.repository.ClassificationRepository;
import com.egg.api.repository.EggTypeRepository;

@Service
public class ClassificationService {
	
	@Autowired
	private ClassificationRepository classificationRepository;
	
	@Autowired
	private EggTypeRepository eggTypeRepository;

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
	
	public ResponseEntity<Classification> createClassifications() {
		
		List <EggType> eggTypeList = eggTypeRepository.findAll();
		
		List <Classification> classificationList = new ArrayList<>();
		
		eggTypeList.forEach(e -> {
			Classification classification = new Classification();
			classification.setEggBase(null);	
			classification.setEggType(e);
			classificationList.add(classification);
		});
		
		 return new ResponseEntity(classificationList, HttpStatus.OK) ;	
		
	}

}
