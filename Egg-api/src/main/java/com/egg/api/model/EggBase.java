package com.egg.api.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "egg_base")
public class EggBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private int quantity;
	
	@Column(name = "category_A")
	private int categoryA;
	
	@Column(name = "category_B")
	private int categoryB;
	
	private int discard;
	
	@NotNull
	@Column(name = "production_date")
	private LocalDate productionDate; 
	
	@NotNull
	@Column(name = "validity_date")
	private LocalDate validityDate;
	
	@NotNull
    @Column(name = "industry_status")
	@Enumerated(EnumType.STRING)
    private IndustryStatus industryStatus;
	
	@JsonIgnoreProperties("chickenLots")
	@ManyToOne
	@JoinColumn(name = "egg_lot_id")
	private EggLot eggLot;
	
	@JsonIgnoreProperties("eggBase")
	@Valid
	@OneToMany(mappedBy = "eggBase", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "egg_base_id")
	private List<Classification> classifications;

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

	public EggLot getEggLot() {
		return eggLot;
	}

	public void setEggLot(EggLot eggLot) {
		this.eggLot = eggLot;
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

	public int getCategoryA() {
		return categoryA;
	}

	public int getCategoryB() {
		return categoryB;
	}

	public int getDiscard() {
		return discard;
	}

	public void setCategoryA(int categoryA) {
		this.categoryA = categoryA;
	}

	public void setCategoryB(int categoryB) {
		this.categoryB = categoryB;
	}

	public void setDiscard(int discard) {
		this.discard = discard;
	}

	public List<Classification> getClassifications() {
		return classifications;
	}

	public void setClassifications(List<Classification> classifications) {
		this.classifications = classifications;
	}
	
	public IndustryStatus getIndustryStatus() {
		return industryStatus;
	}

	public void setIndustryStatus(IndustryStatus industryStatus) {
		this.industryStatus = industryStatus;
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
		EggBase other = (EggBase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
}
