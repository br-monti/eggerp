package com.egg.domain.repository.filter;

import com.egg.domain.model.EggBase;

public class ClassificationFilter {

	private Long id;
	
	private EggBase eggBase;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EggBase getEggBase() {
		return eggBase;
	}

	public void setEggBase(EggBase eggBase) {
		this.eggBase = eggBase;
	}
	
	
}
