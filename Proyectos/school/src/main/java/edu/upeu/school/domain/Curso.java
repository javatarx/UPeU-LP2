package edu.upeu.school.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CURSO")
public class Curso implements Serializable {

	private static final long serialVersionUID = -2701724388095813764L;
	@Id
	@GeneratedValue(generator = "genId")
	@GenericGenerator(name = "genId", strategy = "edu.upeu.school.util.GeneradorIDRandom")
	@Column(name = "ID_CURSO")
	private String id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "NRO_HORAS")
	private int nroHoras;
	@Column(name = "NRO_CREDITOS")
	private int nroCreditos;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "cursos")
	private Set<Alumno> alumnos;

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNroHoras() {
		return nroHoras;
	}

	public void setNroHoras(int nroHoras) {
		this.nroHoras = nroHoras;
	}

	public int getNroCreditos() {
		return nroCreditos;
	}

	public void setNroCreditos(int nroCreditos) {
		this.nroCreditos = nroCreditos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
