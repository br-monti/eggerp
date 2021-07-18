package com.egg.domain.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.domain.model.Product;
import com.egg.domain.repository.filter.ProductFilter;

public interface ProductRepositoryQuery  {
	
	public Page<Product> findByFilter(ProductFilter productFilter, Pageable pageable);

}
