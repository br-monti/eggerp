package com.egg.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChickenLot.class)
public abstract class ChickenLot_ {

	public static volatile SingularAttribute<ChickenLot, Shed> shed;
	public static volatile SingularAttribute<ChickenLot, ChickenLineage> chickenLineage;
	public static volatile SingularAttribute<ChickenLot, String> debicking;
	public static volatile SingularAttribute<ChickenLot, Integer> initialQuantity;
	public static volatile SingularAttribute<ChickenLot, EggLot> eggLot;
	public static volatile SingularAttribute<ChickenLot, Long> id;
	public static volatile SingularAttribute<ChickenLot, LocalDate> birthDate;
	public static volatile SingularAttribute<ChickenLot, Integer> currentQuantity;
	public static volatile SingularAttribute<ChickenLot, LocalDate> accommodationDate;

	public static final String SHED = "shed";
	public static final String CHICKEN_LINEAGE = "chickenLineage";
	public static final String DEBICKING = "debicking";
	public static final String INITIAL_QUANTITY = "initialQuantity";
	public static final String EGG_LOT = "eggLot";
	public static final String ID = "id";
	public static final String BIRTH_DATE = "birthDate";
	public static final String CURRENT_QUANTITY = "currentQuantity";
	public static final String ACCOMMODATION_DATE = "accommodationDate";

}

