package com.egg.api.repository;

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

<<<<<<< HEAD
import com.egg.api.model.Shed;
import com.egg.api.model.Shed_;
import com.egg.api.repository.filter.ShedFilter;

public class ShedRepositoryImpl implements ShedRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Shed> findByFilter(ShedFilter shedFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Shed> criteria = builder.createQuery(Shed.class);
		Root<Shed> root = criteria.from(Shed.class);
		
		Predicate[] predicates = createRestrictions(shedFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Shed> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(shedFilter));
	}

	private Long total(ShedFilter shedFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Shed> root = criteria.from(Shed.class);
		
		Predicate[] predicates = createRestrictions(shedFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void addPaginationRestrictions(TypedQuery<Shed> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRegisterByPage = pageable.getPageSize();
		int firstPageRegister = currentPage * totalRegisterByPage;
		
		query.setFirstResult(firstPageRegister);
		query.setMaxResults(totalRegisterByPage);
		
	}

	private Predicate[] createRestrictions(ShedFilter shedFilter, CriteriaBuilder builder,
			Root<Shed> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(shedFilter.getName())) {
			predicates.add(builder.like(
					builder.lower(root.get(Shed_.name)), "%" + shedFilter.getName().toLowerCase() + "%"));
=======
import com.egg.api.model.ChickenLineage;
import com.egg.api.model.ChickenLineage_;
import com.egg.api.repository.filter.ChickenLineageFilter;

public class ShedRepositoryImpl implements ChickenLineageRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ChickenLineage> findByFilter(ChickenLineageFilter chickenLineageFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ChickenLineage> criteria = builder.createQuery(ChickenLineage.class);
		Root<ChickenLineage> root = criteria.from(ChickenLineage.class);
		
		Predicate[] predicates = createRestrictions(chickenLineageFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ChickenLineage> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(chickenLineageFilter));
	}

	private Long total(ChickenLineageFilter chickenLineageFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<ChickenLineage> root = criteria.from(ChickenLineage.class);
		
		Predicate[] predicates = createRestrictions(chickenLineageFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void addPaginationRestrictions(TypedQuery<ChickenLineage> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRegisterByPage = pageable.getPageSize();
		int firstPageRegister = currentPage * totalRegisterByPage;
		
		query.setFirstResult(firstPageRegister);
		query.setMaxResults(totalRegisterByPage);
		
	}

	private Predicate[] createRestrictions(ChickenLineageFilter chickenLineageFilter, CriteriaBuilder builder,
			Root<ChickenLineage> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(chickenLineageFilter.getLineage())) {
			predicates.add(builder.like(
					builder.lower(root.get(ChickenLineage_.lineage)), "%" + chickenLineageFilter.getLineage().toLowerCase() + "%"));
>>>>>>> branch 'master' of https://github.com/br-monti/eggerp.git
		}		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}