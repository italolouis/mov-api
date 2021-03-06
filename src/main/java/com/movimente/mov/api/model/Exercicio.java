package com.movimente.mov.api.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exercicio")
public class Exercicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod;
	
	private Long exerciciocod;
	
	/*@JsonIgnore
	@NotNull
	@ManyToOne
	@JoinColumn(name = "exerciciocod")
	private TipoExercicio tipoexercicio;*/
	
	@ManyToMany
    @JoinTable(name = "exercicio_serie", joinColumns = @JoinColumn(name = "exerciciocod"), inverseJoinColumns = @JoinColumn(name = "seriecod"))
    private Set<Serie> series;
	
	private Long descanso;

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}

	public Long getExerciciocod() {
		return exerciciocod;
	}

	public void setExerciciocod(Long exerciciocod) {
		this.exerciciocod = exerciciocod;
	}

	public Set<Serie> getSeries() {
		return series;
	}

	public void setSeries(Set<Serie> series) {
		this.series = series;
	}
	
	public Long getDescanso() {
		return descanso;
	}

	public void setDescanso(Long descanso) {
		this.descanso = descanso;
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
		Exercicio other = (Exercicio) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}
}
