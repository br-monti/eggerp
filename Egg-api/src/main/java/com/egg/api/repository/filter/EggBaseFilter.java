package com.egg.api.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.egg.api.model.EggLot;

public class EggBaseFilter {

	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate productionDateInitial;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate productionDateFinal;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate validityDateInitial;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate validityDateFinal;
	
	private EggLot eggLot;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getProductionDateInitial() {
		return productionDateInitial;
	}

	public void setProductionDateInitial(LocalDate productionDateInitial) {
		this.productionDateInitial = productionDateInitial;
	}

	public LocalDate getProductionDateFinal() {
		return productionDateFinal;
	}

	public void setProductionDateFinal(LocalDate productionDateFinal) {
		this.productionDateFinal = productionDateFinal;
	}

	public LocalDate getValidityDateInitial() {
		return validityDateInitial;
	}

	public void setValidityDateInitial(LocalDate validityDateInitial) {
		this.validityDateInitial = validityDateInitial;
	}

	public LocalDate getValidityDateFinal() {
		return validityDateFinal;
	}

	public void setValidityDateFinal(LocalDate validityDateFinal) {
		this.validityDateFinal = validityDateFinal;
	}

	public EggLot getEggLot() {
		return eggLot;
	}

	public void setEggLot(EggLot eggLot) {
		this.eggLot = eggLot;
	}


}
