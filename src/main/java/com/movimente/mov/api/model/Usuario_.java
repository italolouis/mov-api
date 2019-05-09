package com.movimente.mov.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, String> telefone;
	public static volatile SingularAttribute<Usuario, Long> codusu;
	public static volatile SingularAttribute<Usuario, byte[]> foto;
	public static volatile SingularAttribute<Usuario, Endereco> endereco;
	public static volatile SingularAttribute<Usuario, LocalDate> dtnascimento;
	public static volatile SingularAttribute<Usuario, BigDecimal> altura;
	public static volatile SingularAttribute<Usuario, String> genero;
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, String> bloqueio;

}

