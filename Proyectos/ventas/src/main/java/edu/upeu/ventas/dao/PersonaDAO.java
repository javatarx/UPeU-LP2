package edu.upeu.ventas.dao;

import java.util.List;

import edu.upeu.ventas.dominio.Persona;

public interface PersonaDAO {

	void guardar(Persona p);

	List<Persona> listarPersonas();

}
