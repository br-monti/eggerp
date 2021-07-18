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

import com.egg.domain.model.EggLot;
import com.egg.domain.model.EggLot_;
import com.egg.domain.repository.filter.EggLotFilter;
import com.egg.domain.repository.query.EggLotRepositoryQuery;

public class EggLotRepositoryImpl implements EggLotRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<EggLot> findByFilter(EggLotFilter eggLotFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<EggLot> criteria = builder.createQuery(EggLot.class);
		Root<EggLot> root = criteria.from(EggLot.class);
		
		Predicate[] predicates = createRestrictions(eggLotFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<EggLot> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(eggLotFilter));
	}

	private Long total(EggLotFilter eggLotFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<EggLot> root = criteria.from(EggLot.class);
		
		Predicate[] predicates = createRestrictions(eggLotFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void addPaginationRestrictions(TypedQuery<EggLot> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRegisterByPage = pageable.getPageSize();
		int firstPageRegister = currentPage * totalRegisterByPage;
		
		query.setFirstResult(firstPageRegister);
		query.setMaxResults(totalRegisterByPage);
		
	}

	private Predicate[] createRestrictions(EggLotFilter eggLotFilter, CriteriaBuilder builder,
			Root<EggLot> root) {
		List<Predicate> predicates = new ArrayList<>();
		
	
		if (eggLotFilter.getId() != null) {
			predicates.add(builder.and(
					builder.equal((root.get(EggLot_.id)), eggLotFilter.getId())));
		}
		
		if (!StringUtils.isEmpty(eggLotFilter.getName())) {
			predicates.add(builder.like(
					builder.lower(root.get(EggLot_.name)), "%" + eggLotFilter.getName().toLowerCase() + "%"));
		}	
		
		if (!StringUtils.isEmpty(eggLotFilter.getBoxColor())) {
			predicates.add(builder.like(
					builder.lower(root.get(EggLot_.boxColor)), "%" + eggLotFilter.getBoxColor().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
