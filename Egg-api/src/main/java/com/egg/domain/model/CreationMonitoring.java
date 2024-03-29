package com.egg.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "creation_monitoring")
public class CreationMonitoring {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "age_week")
	private int ageWeek;
	
	@NotNull
	@Column(name = "age_day")
	private int ageDay;
	
	@NotNull
	@Column(name = "date_week")
	private LocalDate dateWeek;
		
	@NotNull
	@Column(name = "body_weight")
	private int bodyWeight;
	
	@NotNull
	private int food;
	
	@NotNull
	private int water;
	
	@NotNull
	private int discard;
	
	@NotNull
	private int mortality;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "chicken_lot_id")
	private ChickenLot chickenLot;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAgeWeek() {
		return ageWeek;
	}

	public void setAgeWeek(int ageWeek) {
		this.ageWeek = ageWeek;
	}

	public int getAgeDay() {
		return ageDay;
	}

	public void setAgeDay(int ageDay) {
		this.ageDay = ageDay;
	}

	public LocalDate getDateWeek() {
		return dateWeek;
	}

	public void setDateWeek(LocalDate dateWeek) {
		this.dateWeek = dateWeek;
	}

	public int getBodyWeight() {
		return bodyWeight;
	}

	public void setBodyWeight(int bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public int getDiscard() {
		return discard;
	}

	public void setDiscard(int discard) {
		this.discard = discard;
	}

	public int getMortality() {
		return mortality;
	}

	public void setMortality(int mortality) {
		this.mortality = mortality;
	}

	public ChickenLot getChickenLot() {
		return chickenLot;
	}

	public void setChickenLot(ChickenLot chickenLot) {
		this.chickenLot = chickenLot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreationMonitoring other = (CreationMonitoring) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
