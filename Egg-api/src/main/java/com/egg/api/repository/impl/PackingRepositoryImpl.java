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
import org.springframework.util.StringUtils;

import com.egg.api.model.Packing;
import com.egg.api.model.Packing_;
import com.egg.api.repository.filter.PackingFilter;
import com.egg.api.repository.query.PackingRepositoryQuery;

public class PackingRepositoryImpl implements PackingRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Packing> findByFilter(PackingFilter packingFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Packing> criteria = builder.createQuery(Packing.class);
		Root<Packing> root = criteria.from(Packing.class);
		
		Predicate[] predicates = createRestrictions(packingFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Packing> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(packingFilter));
	}

	private Long total(PackingFilter packingFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Packing> root = criteria.from(Packing.class);
		
		Predicate[] predicates = createRestrictions(packingFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void addPaginationRestrictions(TypedQuery<Packing> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRegisterByPage = pageable.getPageSize();
		int firstPageRegister = currentPage * totalRegisterByPage;
		
		query.setFirstResult(firstPageRegister);
		query.setMaxResults(totalRegisterByPage);
		
	}

	private Predicate[] createRestrictions(PackingFilter packingFilter, CriteriaBuilder builder,
			Root<Packing> root) {
		List<Predicate> predicates = new ArrayList<>();
		
	
		if (packingFilter.getId() != null) {
			predicates.add(builder.and(
					builder.equal((root.get(Packing_.id)), packingFilter.getId())));
		}
		
		if (!StringUtils.isEmpty(packingFilter.getName())) {
			predicates.add(builder.like(
					builder.lower(root.get(Packing_.name)), "%" + packingFilter.getName().toLowerCase() + "%"));
			
		}
		
		if (!StringUtils.isEmpty(packingFilter.getPackingType())) {
			predicates.add(builder.like(
					builder.lower(root.get(Packing_.packingType)), "%" + packingFilter.getPackingType().toLowerCase() + "%"));
			
		}
		

		
			
		return predicates.toArray(new Predicate[predicates.size()]);
	}
}
