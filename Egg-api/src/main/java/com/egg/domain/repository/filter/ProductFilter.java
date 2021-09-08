package com.egg.domain.repository.filter;

import com.egg.domain.model.Packing;

public class ProductFilter {

	private Long id;
	
	private Packing packing;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Packing getPacking() {
		return packing;
	}

	public void setPacking(Packing packing) {
		this.packing = packing;
	}

	
}
