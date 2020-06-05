package com.egg.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "packing")
public class Packing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Column(name = "packing_type")
	private String packingType;
	
	@NotNull
	@Column(name = "quantity_by_packing")
	private int quantityByPacking;
	
	@NotNull
	@Column(name = "packing_by_box")
	private int packingByBox;
	
	@NotNull
	@Column(name = "quantity_by_box")
	private int quantityByBox;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPackingType() {
		return packingType;
	}

	public void setPackingType(String packingType) {
		this.packingType = packingType;
	}

	public int getQuantityByPacking() {
		return quantityByPacking;
	}

	public void setQuantityByPacking(int quantityByPacking) {
		this.quantityByPacking = quantityByPacking;
	}

	public int getPackingByBox() {
		return packingByBox;
	}

	public void setPackingByBox(int packingByBox) {
		this.packingByBox = packingByBox;
	}

	public int getQuantityByBox() {
		return quantityByBox;
	}

	public void setQuantityByBox(int quantityByBox) {
		this.quantityByBox = quantityByBox;
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
		Packing other = (Packing) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
