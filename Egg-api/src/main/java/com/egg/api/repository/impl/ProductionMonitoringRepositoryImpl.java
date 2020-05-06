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

import com.egg.api.model.ProductionMonitoring;
import com.egg.api.model.ProductionMonitoring_;
import com.egg.api.repository.filter.ProductionMonitoringFilter;
import com.egg.api.repository.query.ProductionMonitoringRepositoryQuery;

public class ProductionMonitoringRepositoryImpl implements ProductionMonitoringRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ProductionMonitoring> findByFilter(ProductionMonitoringFilter productionMonitoringFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ProductionMonitoring> criteria = builder.createQuery(ProductionMonitoring.class);
		Root<ProductionMonitoring> root = criteria.from(ProductionMonitoring.class);
		
		Predicate[] predicates = createRestrictions(productionMonitoringFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ProductionMonitoring> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(productionMonitoringFilter));
	}

	private Long total(ProductionMonitoringFilter productionMonitoringFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<ProductionMonitoring> root = criteria.from(ProductionMonitoring.class);
		
		Predicate[] predicates = createRestrictions(productionMonitoringFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void addPaginationRestrictions(TypedQuery<ProductionMonitoring> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRegisterByPage = pageable.getPageSize();
		int firstPageRegister = currentPage * totalRegisterByPage;
		
		query.setFirstResult(firstPageRegister);
		query.setMaxResults(totalRegisterByPage);
		
	}

	private Predicate[] createRestrictions(ProductionMonitoringFilter productionMonitoringFilter, CriteriaBuilder builder,
			Root<ProductionMonitoring> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (productionMonitoringFilter.getChickenLot() != null) {
			predicates.add(builder.and(
					builder.equal((root.get(ProductionMonitoring_.chickenLot)), productionMonitoringFilter.getChickenLot().getId())));
		}
		
		if (productionMonitoringFilter.getDateWeekInitial() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo((root.get(ProductionMonitoring_.dateWeek)), productionMonitoringFilter.getDateWeekInitial()));
		}
		
		if (productionMonitoringFilter.getDateWeekFinal() != null) {
			predicates.add(
					builder.lessThanOrEqualTo((root.get(ProductionMonitoring_.dateWeek)), productionMonitoringFilter.getDateWeekFinal()));
		}
		

		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
