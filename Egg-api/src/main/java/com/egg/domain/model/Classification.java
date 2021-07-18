package com.egg.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "classification")
public class Classification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "egg_type_id")
	private EggType eggType;
	
	@JsonIgnoreProperties("classifications")
	@ManyToOne
	@JoinColumn(name = "egg_base_id")
	private EggBase eggBase;
	
	@JsonIgnoreProperties("classification")
	@Valid
	@OneToMany(mappedBy = "classification", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> products;

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

	public EggType getEggType() {
		return eggType;
	}

	public void setEggType(EggType eggType) {
		this.eggType = eggType;
	}

	public EggBase getEggBase() {
		return eggBase;
	}

	public void setEggBase(EggBase eggBase) {
		this.eggBase = eggBase;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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
		Classification other = (Classification) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
