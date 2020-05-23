package com.egg.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EggBase.class)
public abstract class EggBase_ {

	public static volatile SingularAttribute<EggBase, Integer> quantity;
	public static volatile SingularAttribute<EggBase, LocalDate> productionDate;
	public static volatile SingularAttribute<EggBase, LocalDate> validityDate;
	public static volatile SingularAttribute<EggBase, EggLot> eggLot;
	public static volatile SingularAttribute<EggBase, Long> id;

	public static final String QUANTITY = "quantity";
	public static final String PRODUCTION_DATE = "productionDate";
	public static final String VALIDITY_DATE = "validityDate";
	public static final String EGG_LOT = "eggLot";
	public static final String ID = "id";

}

