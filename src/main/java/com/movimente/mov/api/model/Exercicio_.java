package com.movimente.mov.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Exercicio.class)
public abstract class Exercicio_ {

	public static volatile SingularAttribute<Exercicio, byte[]> image;
	public static volatile SingularAttribute<Exercicio, Equipamento> equipamento;
	public static volatile SingularAttribute<Exercicio, GrupoMuscular> grupo;
	public static volatile SingularAttribute<Exercicio, Long> cod;
	public static volatile SingularAttribute<Exercicio, String> descricao;

}

