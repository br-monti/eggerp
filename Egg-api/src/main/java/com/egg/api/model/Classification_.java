package com.egg.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Classification.class)
public abstract class Classification_ {

	public static volatile SingularAttribute<Classification, Integer> quantity;
	public static volatile SingularAttribute<Classification, EggType> eggType;
	public static volatile SingularAttribute<Classification, EggBase> eggBase;
	public static volatile SingularAttribute<Classification, Long> id;
	public static volatile ListAttribute<Classification, Product> products;

	public static final String QUANTITY = "quantity";
	public static final String EGG_TYPE = "eggType";
	public static final String EGG_BASE = "eggBase";
	public static final String ID = "id";
	public static final String PRODUCTS = "products";

}

