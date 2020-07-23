package com.egg.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, String> nick;
	public static volatile SingularAttribute<Product, EggType> eggType;
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SingularAttribute<Product, Packing> packing;

}

