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

import com.egg.api.model.CreationMonitoring;
import com.egg.api.model.CreationMonitoring_;
import com.egg.api.repository.filter.CreationMonitoringFilter;
import com.egg.api.repository.query.CreationMonitoringRepositoryQuery;

public class CreationMonitoringRepositoryImpl implements CreationMonitoringRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<CreationMonitoring> findByFilter(CreationMonitoringFilter creationMontoringFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<CreationMonitoring> criteria = builder.createQuery(CreationMonitoring.class);
		Root<CreationMonitoring> root = criteria.from(CreationMonitoring.class);
		
		Predicate[] predicates = createRestrictions(creationMontoringFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<CreationMonitoring> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(creationMontoringFilter));
	}

	private Long total(CreationMonitoringFilter creationMonitoringFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<CreationMonitoring> root = criteria.from(CreationMonitoring.class);
		
		Predicate[] predicates = createRestrictions(creationMonitoringFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void addPaginationRestrictions(TypedQuery<CreationMonitoring> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRegisterByPage = pageable.getPageSize();
		int firstPageRegister = currentPage * totalRegisterByPage;
		
		query.setFirstResult(firstPageRegister);
		query.setMaxResults(totalRegisterByPage);
		
	}

	private Predicate[] createRestrictions(CreationMonitoringFilter creationMonitoringFilter, CriteriaBuilder builder,
			Root<CreationMonitoring> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (creationMonitoringFilter.getChickenLot() != null) {
			predicates.add(builder.and(
					builder.equal((root.get(CreationMonitoring_.chickenLot)), creationMonitoringFilter.getChickenLot().getId())));
		}
		
		if (creationMonitoringFilter.getDateWeekInitial() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo((root.get(CreationMonitoring_.dateWeek)), creationMonitoringFilter.getDateWeekInitial()));
		}
		
		if (creationMonitoringFilter.getDateWeekFinal() != null) {
			predicates.add(
					builder.lessThanOrEqualTo((root.get(CreationMonitoring_.dateWeek)), creationMonitoringFilter.getDateWeekFinal()));
		}
		

		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
