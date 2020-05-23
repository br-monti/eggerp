package com.egg.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "egg_type")
public class EggType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String type;
	
	@NotNull
	private String category;
	
	@NotNull
	@Column(name = "min_weight")
	private LocalDate minWeight; 
	
	@NotNull
	@Column(name = "max_weight")
	private LocalDate maxWeight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(LocalDate minWeight) {
		this.minWeight = minWeight;
	}

	public LocalDate getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(LocalDate maxWeight) {
		this.maxWeight = maxWeight;
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
		EggType other = (EggType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
