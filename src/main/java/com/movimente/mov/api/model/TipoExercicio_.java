package com.movimente.mov.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TipoExercicio.class)
public abstract class TipoExercicio_ {

	public static volatile SingularAttribute<TipoExercicio, byte[]> image;
	public static volatile SingularAttribute<TipoExercicio, String> instrucao;
	public static volatile SetAttribute<TipoExercicio, Categoria> categorias;
	public static volatile SingularAttribute<TipoExercicio, Long> cod;
	public static volatile SingularAttribute<TipoExercicio, String> nome;

}

