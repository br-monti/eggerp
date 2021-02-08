package com.egg.api.repository.projection;

public class ClassificationResume {
	
	private Long id;
	private int quantity;
	private Long eggBase;
	private Long eggType;
	
	public ClassificationResume(Long id, int quantity, Long eggBase, Long eggType) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.eggBase = eggBase;
		this.eggType = eggType;
	}

	public Long getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public Long getEggBase() {
		return eggBase;
	}

	public Long getEggType() {
		return eggType;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setEggBase(Long eggBase) {
		this.eggBase = eggBase;
	}

	public void setEggType(Long eggType) {
		this.eggType = eggType;
	}
	
}