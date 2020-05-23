package com.egg.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EggType.class)
public abstract class EggType_ {

	public static volatile SingularAttribute<EggType, LocalDate> minWeight;
	public static volatile SingularAttribute<EggType, Long> id;
	public static volatile SingularAttribute<EggType, LocalDate> maxWeight;
	public static volatile SingularAttribute<EggType, String> type;
	public static volatile SingularAttribute<EggType, String> category;

}

