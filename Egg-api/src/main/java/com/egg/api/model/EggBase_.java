package com.egg.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EggBase.class)
public abstract class EggBase_ {

	public static volatile ListAttribute<EggBase, Classification> classifications;
	public static volatile SingularAttribute<EggBase, Integer> quantity;
	public static volatile SingularAttribute<EggBase, LocalDate> productionDate;
	public static volatile SingularAttribute<EggBase, LocalDate> validityDate;
	public static volatile SingularAttribute<EggBase, EggLot> eggLot;
	public static volatile SingularAttribute<EggBase, IndustryStatus> industryStatus;
	public static volatile SingularAttribute<EggBase, Long> id;

}

