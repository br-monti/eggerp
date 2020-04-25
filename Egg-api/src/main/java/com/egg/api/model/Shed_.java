package com.egg.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Shed.class)
public abstract class Shed_ {

	public static volatile SingularAttribute<Shed, ShedManufacturer> shedManufacturer;
	public static volatile SingularAttribute<Shed, String> name;
	public static volatile SingularAttribute<Shed, String> model;
	public static volatile SingularAttribute<Shed, Long> id;
	public static volatile SingularAttribute<Shed, String> type;
	public static volatile SingularAttribute<Shed, Integer> capacity;

}

