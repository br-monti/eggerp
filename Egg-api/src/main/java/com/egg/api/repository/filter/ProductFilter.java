package com.egg.api.repository.filter;

import com.egg.api.model.EggType;
import com.egg.api.model.Packing;

public class ProductFilter {

	private Long id;
	
	private Packing packing;
	
	private EggType eggType;

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

	public EggType getEggType() {
		return eggType;
	}

	public void setEggType(EggType eggType) {
		this.eggType = eggType;
	}


	
}
