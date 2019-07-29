package com.movimente.mov.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Categoria.class)
public abstract class Categoria_ {

	public static volatile SingularAttribute<Categoria, Categoria> parent;
	public static volatile SetAttribute<Categoria, Categoria> subCategorias;
	public static volatile SetAttribute<Categoria, TipoExercicio> tipoExercicios;
	public static volatile SingularAttribute<Categoria, Long> cod;
	public static volatile SingularAttribute<Categoria, String> nome;

}

