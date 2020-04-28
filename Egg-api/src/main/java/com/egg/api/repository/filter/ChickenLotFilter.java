package com.egg.api.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.egg.api.model.Shed;

public class ChickenLotFilter {

	private Long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDateInitial;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDateFinal;
	
	private Shed shed;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getBirthDateInitial() {
		return birthDateInitial;
	}
	public void setBirthDateInitial(LocalDate birthDateInitial) {
		this.birthDateInitial = birthDateInitial;
	}
	public LocalDate getBirthDateFinal() {
		return birthDateFinal;
	}
	public void setBirthDateFinal(LocalDate birthDateFinal) {
		this.birthDateFinal = birthDateFinal;
	}
	public Shed getShed() {
		return shed;
	}
	public void setShed(Shed shed) {
		this.shed = shed;
	}

}
