package com.movimente.mov.api.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	private Long cod;
	
	@Column(name = "nome", nullable = false)
    private String nome;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "parentid")
    private Categoria parent;
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categorias")
    private Set<TipoExercicio> tipoExercicios;
    
    @OneToMany(mappedBy = "parent")
    private Set<Categoria> subCategorias;
    
	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getParent() {
		return parent;
	}

	public void setParent(Categoria parent) {
		this.parent = parent;
	}
	
	public Set<TipoExercicio> getTipoExercicios() {
		return tipoExercicios;
	}

	public void setTipoExercicios(Set<TipoExercicio> tipoExercicios) {
		this.tipoExercicios = tipoExercicios;
	}

	public Set<Categoria> getSubCategorias() {
		return subCategorias;
	}

	public void setSubCategorias(Set<Categoria> subCategorias) {
		this.subCategorias = subCategorias;
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
		Categoria other = (Categoria) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}
   
}
