package com.egg.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "egg_lot")
public class EggLot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	@JoinColumn(name = "box_color")
	private String boxColor;
	
	//@JsonIgnoreProperties("eggLot")
	//@Valid	
	//@OneToMany(mappedBy = "eggLot", cascade = CascadeType.ALL)
	@OneToMany
	@JoinColumn(name = "egg_lot_id")
	private List<ChickenLot> chickenLots;

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

	public String getBoxColor() {
		return boxColor;
	}

	public void setBoxColor(String boxColor) {
		this.boxColor = boxColor;
	}
	
	public List<ChickenLot> getChickenLots() {
		return chickenLots;
	}

	public void setChickenLots(List<ChickenLot> chickenLots) {
		this.chickenLots = chickenLots;
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
		EggLot other = (EggLot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
