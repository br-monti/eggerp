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

import com.egg.api.model.Product;
import com.egg.api.model.Product_;
import com.egg.api.repository.filter.ProductFilter;
import com.egg.api.repository.query.ProductRepositoryQuery;

public class ProductRepositoryImpl implements ProductRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Product> findByFilter(ProductFilter productFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
		Root<Product> root = criteria.from(Product.class);
		
		Predicate[] predicates = createRestrictions(productFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Product> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(productFilter));
	}

	private Long total(ProductFilter productFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Product> root = criteria.from(Product.class);
		
		Predicate[] predicates = createRestrictions(productFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void addPaginationRestrictions(TypedQuery<Product> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRegisterByPage = pageable.getPageSize();
		int firstPageRegister = currentPage * totalRegisterByPage;
		
		query.setFirstResult(firstPageRegister);
		query.setMaxResults(totalRegisterByPage);
		
	}

	private Predicate[] createRestrictions(ProductFilter productFilter, CriteriaBuilder builder,
			Root<Product> root) {
		List<Predicate> predicates = new ArrayList<>();
		
	
		if (productFilter.getId() != null) {
			predicates.add(builder.and(
					builder.equal((root.get(Product_.id)), productFilter.getId())));
		}
		
		if (productFilter.getPacking() != null) {
			predicates.add(builder.and(
					builder.equal((root.get(Product_.packing)), productFilter.getPacking().getId())));
		}
		
		if (productFilter.getEggType() != null) {
			predicates.add(builder.and(
					builder.equal((root.get(Product_.eggType)), productFilter.getEggType().getId())));
		}
		
			
		return predicates.toArray(new Predicate[predicates.size()]);
	}
}
