package com.egg.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, Integer> quantity;
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SingularAttribute<Product, Packing> packing;
	public static volatile SingularAttribute<Product, Classification> classification;

	public static final String QUANTITY = "quantity";
	public static final String ID = "id";
	public static final String PACKING = "packing";
	public static final String CLASSIFICATION = "classification";

}

