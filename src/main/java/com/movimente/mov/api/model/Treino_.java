package com.movimente.mov.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Treino.class)
public abstract class Treino_ {

	public static volatile SingularAttribute<Treino, Long> cod;
	public static volatile SingularAttribute<Treino, Usuario> usuario;
	public static volatile SingularAttribute<Treino, String> dia;
	public static volatile SetAttribute<Treino, Exercicio> exercicio;

}

