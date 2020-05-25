package com.egg.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.api.model.Classification;
import com.egg.api.repository.ClassificationRepository;

@Service
public class ClassificationService {
	
	@Autowired
	private ClassificationRepository classificationRepository;

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

}
