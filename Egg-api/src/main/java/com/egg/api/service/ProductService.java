package com.egg.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egg.api.model.Product;
import com.egg.api.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public Product update(Long id, Product product) {
		Product productSaved = findProductById(id);
		
		//productSaved.getChickenLots().clear();
		//productSaved.getChickenLots().addAll(product.getChickenLots());		
		//productSaved.getChickenLots().forEach(c -> c.setProduct(productSaved));
		
		BeanUtils.copyProperties(product, productSaved, "id");
		return productRepository.save(productSaved);
	}

	
	public Product findProductById(Long id) {
		Product productSaved = productRepository.findById(id).orElse(null);
		if (productSaved == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return productSaved;
	}


	public Product save(Product product) {
		//product.getChickenLots().forEach(c -> c.setProduct(product));
		return productRepository.save(product);
	}

}
