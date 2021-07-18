package com.egg.domain.model;

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

	public static final String NAME = "name";
	public static final String QUANTITY_BY_BOX = "quantityByBox";
	public static final String ID = "id";
	public static final String PACKING_BY_BOX = "packingByBox";
	public static final String PACKING_TYPE = "packingType";
	public static final String QUANTITY_BY_PACKING = "quantityByPacking";

}

