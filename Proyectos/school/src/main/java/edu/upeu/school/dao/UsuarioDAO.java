package edu.upeu.school.dao;

import edu.upeu.school.domain.Usuario;

public interface UsuarioDAO extends GenericDao<Usuario, String>{

	Usuario getUsuarioPorUsernameYContrasenia(String username,
			String contrasenia);
}
