package com.egg.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.egg.api.model.Product;
import com.egg.api.repository.filter.ProductFilter;

public interface ProductRepositoryQuery  {
	
	public Page<Product> findByFilter(ProductFilter productFilter, Pageable pageable);

}
