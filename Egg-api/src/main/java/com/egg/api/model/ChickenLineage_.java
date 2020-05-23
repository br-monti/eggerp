package com.egg.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChickenLineage.class)
public abstract class ChickenLineage_ {

	public static volatile SingularAttribute<ChickenLineage, String> lineage;
	public static volatile SingularAttribute<ChickenLineage, String> chickenColor;
	public static volatile SingularAttribute<ChickenLineage, String> provider;
	public static volatile SingularAttribute<ChickenLineage, Long> id;

	public static final String LINEAGE = "lineage";
	public static final String CHICKEN_COLOR = "chickenColor";
	public static final String PROVIDER = "provider";
	public static final String ID = "id";

}

