package edu.upeu.ventas.service;

import java.util.List;

import edu.upeu.ventas.web.form.AlumnoForm;

public interface AlumnoService {
	List<AlumnoForm> getListaAlumnos();

	void guardarAlumno(AlumnoForm p);
}
