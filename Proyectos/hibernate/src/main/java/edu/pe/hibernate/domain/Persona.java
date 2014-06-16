package edu.pe.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity()
@Table(name = "PERSONA")
public class Persona {

	@Id
	@GeneratedValue(generator = "hola")
	@GenericGenerator(name = "hola", strategy = "increment")
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APE_PAT")
	private String apellidoPaterno;
	@Column(name = "APE_MAT")
	private String apellidoMaterno;

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

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Persona(String nombre, String apellidoPaterno, String apellidoMaterno) {
		super();
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
	}

	public Persona() {
		super();
	}

}
