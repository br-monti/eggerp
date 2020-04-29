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

import com.egg.api.model.ChickenLot;
import com.egg.api.model.ChickenLot_;
import com.egg.api.repository.filter.ChickenLotFilter;
import com.egg.api.repository.query.ChickenLotRepositoryQuery;

public class ChickenLotRepositoryImpl implements ChickenLotRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ChickenLot> findByFilter(ChickenLotFilter chickenLotFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ChickenLot> criteria = builder.createQuery(ChickenLot.class);
		Root<ChickenLot> root = criteria.from(ChickenLot.class);
		
		Predicate[] predicates = createRestrictions(chickenLotFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ChickenLot> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(chickenLotFilter));
	}

	private Long total(ChickenLotFilter chickenLotFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<ChickenLot> root = criteria.from(ChickenLot.class);
		
		Predicate[] predicates = createRestrictions(chickenLotFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void addPaginationRestrictions(TypedQuery<ChickenLot> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRegisterByPage = pageable.getPageSize();
		int firstPageRegister = currentPage * totalRegisterByPage;
		
		query.setFirstResult(firstPageRegister);
		query.setMaxResults(totalRegisterByPage);
		
	}

	private Predicate[] createRestrictions(ChickenLotFilter chickenLotFilter, CriteriaBuilder builder,
			Root<ChickenLot> root) {
		List<Predicate> predicates = new ArrayList<>();
		
//		if (!StringUtils.isEmpty(chickenLotFilter.getId())) {
//			predicates.add(builder.like(root.get(ChickenLot_.id.toString()), "%" + chickenLotFilter.getId() + "%"));
//		}
		
		if (chickenLotFilter.getId() != null) {
			predicates.add(builder.and(
					builder.equal((root.get(ChickenLot_.id)), chickenLotFilter.getId())));
		}
		
		if (chickenLotFilter.getBirthDateInitial() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo((root.get(ChickenLot_.birthDate)), chickenLotFilter.getBirthDateInitial()));
		}
		
		if (chickenLotFilter.getBirthDateFinal() != null) {
			predicates.add(
					builder.lessThanOrEqualTo((root.get(ChickenLot_.birthDate)), chickenLotFilter.getBirthDateInitial()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
