package edu.upeu.school.service;

import java.util.List;

import edu.upeu.school.web.form.AlumnoForm;

public interface AlumnoService {

	List<AlumnoForm> listarAlumnos();

	void guardarAlumno(AlumnoForm af);

}
