package com.egg.api.repository.filter;

import com.egg.api.model.Packing;

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
