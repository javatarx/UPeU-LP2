package edu.upeu.ventas.dao;

import java.util.List;

import edu.upeu.ventas.dominio.Curso;

public interface CursoDAO {

	void insertar(Curso c);

	List<Curso> listar();

	Curso getCursoPorId(String id);

	void actualizar(Curso c);

}
