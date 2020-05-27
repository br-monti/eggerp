package com.egg.api.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.ChickenLot_;
import com.egg.api.model.Classification;
import com.egg.api.model.Classification_;
import com.egg.api.repository.filter.ClassificationFilter;
import com.egg.api.repository.query.ClassificationRepositoryQuery;

public class ClassificationRepositoryImpl implements ClassificationRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Classification> findByFilter(ClassificationFilter classificationFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Classification> criteria = builder.createQuery(Classification.class);
		Root<Classification> root = criteria.from(Classification.class);
		
		Predicate[] predicates = createRestrictions(classificationFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Classification> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(classificationFilter));
	}

	private Long total(ClassificationFilter classificationFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Classification> root = criteria.from(Classification.class);
		
		Predicate[] predicates = createRestrictions(classificationFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void addPaginationRestrictions(TypedQuery<Classification> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRegisterByPage = pageable.getPageSize();
		int firstPageRegister = currentPage * totalRegisterByPage;
		
		query.setFirstResult(firstPageRegister);
		query.setMaxResults(totalRegisterByPage);
		
	}

	private Predicate[] createRestrictions(ClassificationFilter classificationFilter, CriteriaBuilder builder,
			Root<Classification> root) {
		List<Predicate> predicates = new ArrayList<>();
		
	
		if (classificationFilter.getId() != null) {
			predicates.add(builder.and(
					builder.equal((root.get(Classification_.id)), classificationFilter.getId())));
		}
		
		if (classificationFilter.getEggBase() != null) {
			predicates.add(builder.and(
					builder.equal((root.get(Classification_.eggBase)), classificationFilter.getEggBase().getId())));
		}
		
			
		return predicates.toArray(new Predicate[predicates.size()]);
	}
}
