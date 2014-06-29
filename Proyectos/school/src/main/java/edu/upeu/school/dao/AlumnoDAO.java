package edu.upeu.school.dao;

import edu.upeu.school.domain.Alumno;

public interface AlumnoDAO extends GenericDao<Alumno, String> {

	void eliminarCursoAlumno(String idAlumno, String idCurso);

}
