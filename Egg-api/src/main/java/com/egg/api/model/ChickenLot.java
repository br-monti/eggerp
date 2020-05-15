package com.egg.api.model;

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
@Table(name = "chicken_lot")
public class ChickenLot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@NotNull
	@Column(name = "accommodation_date")
	private LocalDate accommodationDate;
	
	@NotNull
	@Column(name = "initial_quantity")
	private int initialQuantity;
	
	@NotNull
	@Column(name = "current_quantity")
	private int currentQuantity;
	
	@NotNull
	private String debicking;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "chicken_lineage_id")
	private ChickenLineage chickenLineage;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "shed_id")
	private Shed shed;
	
	
	@ManyToOne
	@JoinColumn(name = "egg_lot_id")
	private EggLot eggLot;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getAccommodationDate() {
		return accommodationDate;
	}

	public void setAccommodationDate(LocalDate accommodationDate) {
		this.accommodationDate = accommodationDate;
	}

	public int getInitialQuantity() {
		return initialQuantity;
	}

	public void setInitialQuantity(int initialQuantity) {
		this.initialQuantity = initialQuantity;
	}

	public int getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public String getDebicking() {
		return debicking;
	}

	public void setDebicking(String debicking) {
		this.debicking = debicking;
	}

	public ChickenLineage getChickenLineage() {
		return chickenLineage;
	}

	public void setChickenLineage(ChickenLineage chickenLineage) {
		this.chickenLineage = chickenLineage;
	}

	public Shed getShed() {
		return shed;
	}

	public void setShed(Shed shed) {
		this.shed = shed;
	}
	
	public EggLot getEggLot() {
		return eggLot;
	}

	public void setEggLot(EggLot eggLot) {
		this.eggLot = eggLot;
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
		ChickenLot other = (ChickenLot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
