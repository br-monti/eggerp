package com.egg.domain.repository.impl;

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
import org.springframework.util.StringUtils;

import com.egg.domain.model.EggType;
import com.egg.domain.model.EggType_;
import com.egg.domain.repository.filter.EggTypeFilter;
import com.egg.domain.repository.query.EggTypeRepositoryQuery;

public class EggTypeRepositoryImpl implements EggTypeRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<EggType> findByFilter(EggTypeFilter eggTypeFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<EggType> criteria = builder.createQuery(EggType.class);
		Root<EggType> root = criteria.from(EggType.class);
		
		Predicate[] predicates = createRestrictions(eggTypeFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<EggType> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(eggTypeFilter));
	}

	private Long total(EggTypeFilter eggTypeFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<EggType> root = criteria.from(EggType.class);
		
		Predicate[] predicates = createRestrictions(eggTypeFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void addPaginationRestrictions(TypedQuery<EggType> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRegisterByPage = pageable.getPageSize();
		int firstPageRegister = currentPage * totalRegisterByPage;
		
		query.setFirstResult(firstPageRegister);
		query.setMaxResults(totalRegisterByPage);
		
	}

	private Predicate[] createRestrictions(EggTypeFilter eggTypeFilter, CriteriaBuilder builder,
			Root<EggType> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		
		if (!StringUtils.isEmpty(eggTypeFilter.getType())) {
			predicates.add(builder.like(
					builder.lower(root.get(EggType_.type)), "%" + eggTypeFilter.getType().toLowerCase() + "%"));
		}	
		
		if (!StringUtils.isEmpty(eggTypeFilter.getCategory())) {
			predicates.add(builder.like(
					builder.lower(root.get(EggType_.category)), "%" + eggTypeFilter.getCategory().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
