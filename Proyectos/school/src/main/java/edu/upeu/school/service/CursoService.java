package edu.upeu.school.service;

import java.util.List;

import edu.upeu.school.web.form.CursoForm;

public interface CursoService {

	List<CursoForm> listarCursosAlumno(String id);

	CursoForm getCursoPorId(String id);

	void guardar(CursoForm p);

	List<CursoForm> listar();

}
