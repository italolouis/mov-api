package com.movimente.mov.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipamento")
public class Equipamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codequip;
	private String descricao;
	
	public Long getCodequip() {
		return codequip;
	}
	public void setCodequip(Long codequip) {
		this.codequip = codequip;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}

