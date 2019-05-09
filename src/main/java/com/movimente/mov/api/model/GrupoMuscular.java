package com.movimente.mov.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupo_muscular")
public class GrupoMuscular {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codgrupo;
	private String descricao;
	
	public Long getCodgrupo() {
		return codgrupo;
	}
	public void setCodgrupo(Long codgrupo) {
		this.codgrupo = codgrupo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
