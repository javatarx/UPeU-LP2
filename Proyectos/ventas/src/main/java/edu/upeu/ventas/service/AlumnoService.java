package edu.upeu.ventas.service;

import java.util.List;

import edu.upeu.ventas.web.form.AlumnoForm;

public interface AlumnoService {
	List<AlumnoForm> listar();

	void guardar(AlumnoForm p);

	AlumnoForm getAlumnoPorId(String id);

	AlumnoForm getAlumnoCursosPorId(String id);

	void eliminarCursoAlumno(String idAlumno, String idCurso);
}
