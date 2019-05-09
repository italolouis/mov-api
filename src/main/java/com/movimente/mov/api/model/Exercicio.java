package com.movimente.mov.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exercicio")
public class Exercicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod;
	private String descricao;
	
	@Lob
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name = "grupo", referencedColumnName="codgrupo")
	private GrupoMuscular grupo;
	
	@ManyToOne
	@JoinColumn(name = "equipamento", referencedColumnName="codequip")
	private Equipamento equipamento;

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public GrupoMuscular getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoMuscular grupo) {
		this.grupo = grupo;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
}
