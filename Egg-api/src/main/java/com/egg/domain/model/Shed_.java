package com.egg.domain.model;

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

	public static final String SHED_MANUFACTURER = "shedManufacturer";
	public static final String NAME = "name";
	public static final String MODEL = "model";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String CAPACITY = "capacity";

}

