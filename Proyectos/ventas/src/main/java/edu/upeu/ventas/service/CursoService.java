package edu.upeu.ventas.service;

import java.util.List;

import edu.upeu.ventas.web.form.CursoForm;

public interface CursoService {
	List<CursoForm> listar();

	void guardar(CursoForm p);

	CursoForm getCursoPorId(String id);

	List<CursoForm> listarCursosAlumno(String id);
}
