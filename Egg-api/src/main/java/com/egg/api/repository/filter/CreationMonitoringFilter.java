package com.egg.api.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.egg.api.model.ChickenLot;

public class CreationMonitoringFilter {


	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateWeekInitial;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateWeekFinal;
	
	private ChickenLot chickenLot;

	public LocalDate getDateWeekInitial() {
		return dateWeekInitial;
	}

	public void setDateWeekInitial(LocalDate dateWeekInitial) {
		this.dateWeekInitial = dateWeekInitial;
	}

	public LocalDate getDateWeekFinal() {
		return dateWeekFinal;
	}

	public void setDateWeekFinal(LocalDate dateWeekFinal) {
		this.dateWeekFinal = dateWeekFinal;
	}

	public ChickenLot getChickenLot() {
		return chickenLot;
	}

	public void setChickenLot(ChickenLot chickenLot) {
		this.chickenLot = chickenLot;
	}
	

	

}
