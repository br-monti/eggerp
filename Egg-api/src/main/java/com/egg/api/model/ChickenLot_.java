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

}

