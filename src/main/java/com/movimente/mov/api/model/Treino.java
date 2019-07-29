package com.movimente.mov.api.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "treino")
public class Treino {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod;
	private String dia;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "usuariocod")
	private Usuario usuario;
	
	@ManyToMany
    @JoinTable(name = "treino_exercicios", joinColumns = @JoinColumn(name = "treinocod"), inverseJoinColumns = @JoinColumn(name = "exercicioscod"))
    private Set<Exercicio> exercicio;

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Exercicio> getExercicios() {
		return exercicio;
	}

	public void setExercicios(Set<Exercicio> exercicio) {
		this.exercicio = exercicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treino other = (Treino) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}
	
}
