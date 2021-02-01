package com.egg.api.repository.projection;

import java.time.LocalDate;

import com.egg.api.model.IndustryStatus;

public class EggBaseResume {
	
	private Long id;
	private int quantity;
	private int categoryA;
	private int categoryB;
	private int discard;
	private LocalDate productionDate; 
	private LocalDate validityDate;
	private IndustryStatus industryStatus;
	private Long eggLot;
	private String name;	
	private String boxColor;
	public EggBaseResume(Long id, int quantity, int categoryA, int categoryB, int discard, LocalDate productionDate,
			LocalDate validityDate, IndustryStatus industryStatus, Long eggLot, String name, String boxColor) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.categoryA = categoryA;
		this.categoryB = categoryB;
		this.discard = discard;
		this.productionDate = productionDate;
		this.validityDate = validityDate;
		this.industryStatus = industryStatus;
		this.eggLot = eggLot;
		this.name = name;
		this.boxColor = boxColor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCategoryA() {
		return categoryA;
	}
	public void setCategoryA(int categoryA) {
		this.categoryA = categoryA;
	}
	public int getCategoryB() {
		return categoryB;
	}
	public void setCategoryB(int categoryB) {
		this.categoryB = categoryB;
	}
	public int getDiscard() {
		return discard;
	}
	public void setDiscard(int discard) {
		this.discard = discard;
	}
	public LocalDate getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(LocalDate productionDate) {
		this.productionDate = productionDate;
	}
	public LocalDate getValidityDate() {
		return validityDate;
	}
	public void setValidityDate(LocalDate validityDate) {
		this.validityDate = validityDate;
	}
	public IndustryStatus getIndustryStatus() {
		return industryStatus;
	}
	public void setIndustryStatus(IndustryStatus industryStatus) {
		this.industryStatus = industryStatus;
	}
	public Long getEggLot() {
		return eggLot;
	}
	public void setEggLot(Long eggLot) {
		this.eggLot = eggLot;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBoxColor() {
		return boxColor;
	}
	public void setBoxColor(String boxColor) {
		this.boxColor = boxColor;
	}	
	


	
}
