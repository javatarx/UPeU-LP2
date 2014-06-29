package edu.upeu.ventas.dominio;

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
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ID_CURSO")
	private Long id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

}
