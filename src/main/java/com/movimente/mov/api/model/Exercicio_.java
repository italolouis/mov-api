package com.movimente.mov.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Exercicio.class)
public abstract class Exercicio_ {

	public static volatile SingularAttribute<Exercicio, Long> descanso;
	public static volatile SetAttribute<Exercicio, Serie> series;
	public static volatile SingularAttribute<Exercicio, Long> cod;
	public static volatile SingularAttribute<Exercicio, Long> exerciciocod;

}

