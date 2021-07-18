package com.egg.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EggType.class)
public abstract class EggType_ {

	public static volatile SingularAttribute<EggType, Integer> minWeight;
	public static volatile SingularAttribute<EggType, Long> id;
	public static volatile SingularAttribute<EggType, Integer> maxWeight;
	public static volatile SingularAttribute<EggType, String> type;
	public static volatile SingularAttribute<EggType, String> category;

	public static final String MIN_WEIGHT = "minWeight";
	public static final String ID = "id";
	public static final String MAX_WEIGHT = "maxWeight";
	public static final String TYPE = "type";
	public static final String CATEGORY = "category";

}

