package edu.upeu.ventas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.upeu.ventas.dao.PersonaDAO;
import edu.upeu.ventas.dominio.Persona;
import edu.upeu.ventas.util.DBConexion;

public class PersonaDAOJdbcImpl implements PersonaDAO {

	public void guardar(Persona p) {

		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("insert into persona(id,nombre,ape_pat,ape_mat) values(uuid(),?,?,?)");

			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApePat());
			ps.setString(3, p.getApeMat());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}

	}

	public List<Persona> listarPersonas() {
		List<Persona> lista = new ArrayList<Persona>();

		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("select * from persona");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Persona p = new Persona();
				p.setId(rs.getString("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApePat(rs.getString("ape_pat"));
				p.setApeMat(rs.getString("ape_mat"));

				lista.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}
		return lista;
	}

}
