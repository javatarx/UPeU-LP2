package edu.upeu.ventas.dao;

import java.util.List;

import edu.upeu.ventas.dominio.Alumno;

public interface AlumnoDAO {

	void guardar(Alumno p);

	List<Alumno> listarAlumnos();

}
