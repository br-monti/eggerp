package com.egg.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Classification.class)
public abstract class Classification_ {

	public static volatile SingularAttribute<Classification, Product> product;
	public static volatile SingularAttribute<Classification, Integer> quantity;
	public static volatile SingularAttribute<Classification, Long> id;

	public static final String PRODUCT = "product";
	public static final String QUANTITY = "quantity";
	public static final String ID = "id";

}

