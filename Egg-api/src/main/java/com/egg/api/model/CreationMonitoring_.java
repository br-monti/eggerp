package com.egg.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CreationMonitoring.class)
public abstract class CreationMonitoring_ {

	public static volatile SingularAttribute<CreationMonitoring, Integer> discard;
	public static volatile SingularAttribute<CreationMonitoring, Integer> ageWeek;
	public static volatile SingularAttribute<CreationMonitoring, Integer> mortality;
	public static volatile SingularAttribute<CreationMonitoring, Long> id;
	public static volatile SingularAttribute<CreationMonitoring, Integer> ageDay;
	public static volatile SingularAttribute<CreationMonitoring, Integer> bodyWeight;
	public static volatile SingularAttribute<CreationMonitoring, Integer> water;
	public static volatile SingularAttribute<CreationMonitoring, ChickenLot> chickenLot;
	public static volatile SingularAttribute<CreationMonitoring, LocalDate> dateWeek;
	public static volatile SingularAttribute<CreationMonitoring, Integer> food;

}

