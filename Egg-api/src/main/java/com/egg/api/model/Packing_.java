package com.egg.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Packing.class)
public abstract class Packing_ {

	public static volatile SingularAttribute<Packing, String> name;
	public static volatile SingularAttribute<Packing, Integer> quantityByBox;
	public static volatile SingularAttribute<Packing, Long> id;
	public static volatile SingularAttribute<Packing, Integer> packingByBox;
	public static volatile SingularAttribute<Packing, String> packingType;
	public static volatile SingularAttribute<Packing, Integer> quantityByPacking;

}

