package edu.upeu.school.web.form;

import java.util.List;

public class AlumnoForm {

	private String id;
	private String nombre;
	private String apePat;
	private String apeMat;
	private List<CursoForm> cursos;

	public List<CursoForm> getCursos() {
		return cursos;
	}

	public void setCursos(List<CursoForm> cursos) {
		this.cursos = cursos;
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

	public String getApePat() {
		return apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	public String getApeMat() {
		return apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}

}
