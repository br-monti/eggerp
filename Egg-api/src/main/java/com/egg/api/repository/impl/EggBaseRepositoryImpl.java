package com.egg.api.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.EggBase;
import com.egg.api.model.EggBase_;
import com.egg.api.model.EggLot_;
import com.egg.api.repository.filter.EggBaseFilter;
import com.egg.api.repository.projection.EggBaseResume;
import com.egg.api.repository.query.EggBaseRepositoryQuery;

public class EggBaseRepositoryImpl implements EggBaseRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<EggBase> findByFilter(EggBaseFilter eggBaseFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<EggBase> criteria = builder.createQuery(EggBase.class);
		Root<EggBase> root = criteria.from(EggBase.class);
		
		Predicate[] predicates = createRestrictions(eggBaseFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<EggBase> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(eggBaseFilter));
	}
	
	@Override
	public Page<EggBaseResume> resume(EggBaseFilter eggBaseFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<EggBaseResume> criteria = builder.createQuery(EggBaseResume.class);
		Root<EggBase> root = criteria.from(EggBase.class);
		
		criteria.select(builder.construct(EggBaseResume.class
				, root.get(EggBase_.id), root.get(EggBase_.quantity)
				, root.get(EggBase_.categoryA), root.get(EggBase_.categoryB)
				, root.get(EggBase_.discard), root.get(EggBase_.productionDate)
				, root.get(EggBase_.validityDate), root.get(EggBase_.industryStatus)
				, root.get(EggBase_.eggLot).get(EggLot_.id)
				, root.get(EggBase_.eggLot).get(EggLot_.name)
				, root.get(EggBase_.eggLot).get(EggLot_.boxColor)));
		
		Predicate[] predicates = createRestrictions(eggBaseFilter, builder, root);
		criteria.where(predicates);
		
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(builder.desc(root.get(EggBase_.id)));
		orderList.add(builder.desc(root.get(EggBase_.eggLot).get(EggLot_.id)));

		criteria.orderBy(orderList);
		//criteria.orderBy(builder.desc(root.get(EggBase_.id), root.get(EggBase_.eggLot).get(EggLot_.name)));
		TypedQuery<EggBaseResume> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(eggBaseFilter));
	}


	private Long total(EggBaseFilter eggBaseFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<EggBase> root = criteria.from(EggBase.class);
		
		Predicate[] predicates = createRestrictions(eggBaseFilter, builder, root);		
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void addPaginationRestrictions(TypedQuery<?> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRegisterByPage = pageable.getPageSize();
		int firstPageRegister = currentPage * totalRegisterByPage;
		
		query.setFirstResult(firstPageRegister);
		query.setMaxResults(totalRegisterByPage);
		
	}

	private Predicate[] createRestrictions(EggBaseFilter eggBaseFilter, CriteriaBuilder builder,
			Root<EggBase> root) {
		List<Predicate> predicates = new ArrayList<>();
		
	
		if (eggBaseFilter.getId() != null) {
			predicates.add(builder.and(
					builder.equal((root.get(EggBase_.id)), eggBaseFilter.getId())));
		}
		
		if (eggBaseFilter.getProductionDateInitial() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo((root.get(EggBase_.productionDate)), eggBaseFilter.getProductionDateInitial()));
		}
		
		if (eggBaseFilter.getProductionDateFinal() != null) {
			predicates.add(
					builder.lessThanOrEqualTo((root.get(EggBase_.productionDate)), eggBaseFilter.getProductionDateFinal()));
		}
		
		if (eggBaseFilter.getValidityDateInitial() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo((root.get(EggBase_.validityDate)), eggBaseFilter.getValidityDateInitial()));
		}
		
		if (eggBaseFilter.getValidityDateFinal() != null) {
			predicates.add(
					builder.lessThanOrEqualTo((root.get(EggBase_.validityDate)), eggBaseFilter.getValidityDateFinal()));
		}
		
		if (eggBaseFilter.getEggLot() != null) {
			predicates.add(builder.and(
					builder.equal((root.get(EggBase_.eggLot)), eggBaseFilter.getEggLot().getId())));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}


}
