package com.egg.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EggLot.class)
public abstract class EggLot_ {

	public static volatile ListAttribute<EggLot, ChickenLot> chickenLots;
	public static volatile SingularAttribute<EggLot, String> name;
	public static volatile SingularAttribute<EggLot, String> boxColor;
	public static volatile SingularAttribute<EggLot, Long> id;

	public static final String CHICKEN_LOTS = "chickenLots";
	public static final String NAME = "name";
	public static final String BOX_COLOR = "boxColor";
	public static final String ID = "id";

}

