package com.egg.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductionMonitoring.class)
public abstract class ProductionMonitoring_ {

	public static volatile SingularAttribute<ProductionMonitoring, Integer> discard;
	public static volatile SingularAttribute<ProductionMonitoring, Integer> ageWeek;
	public static volatile SingularAttribute<ProductionMonitoring, Integer> water;
	public static volatile SingularAttribute<ProductionMonitoring, Integer> eggWeight;
	public static volatile SingularAttribute<ProductionMonitoring, ChickenLot> chickenLot;
	public static volatile SingularAttribute<ProductionMonitoring, Integer> food;
	public static volatile SingularAttribute<ProductionMonitoring, Integer> totalProduction;
	public static volatile SingularAttribute<ProductionMonitoring, Integer> mortality;
	public static volatile SingularAttribute<ProductionMonitoring, Integer> firstEggs;
	public static volatile SingularAttribute<ProductionMonitoring, Long> id;
	public static volatile SingularAttribute<ProductionMonitoring, Integer> ageDay;
	public static volatile SingularAttribute<ProductionMonitoring, Integer> bodyWeight;
	public static volatile SingularAttribute<ProductionMonitoring, LocalDate> dateWeek;
	public static volatile SingularAttribute<ProductionMonitoring, Integer> secondEggs;

}

