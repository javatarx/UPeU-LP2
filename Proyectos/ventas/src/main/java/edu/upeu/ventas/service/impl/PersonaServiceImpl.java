package edu.upeu.ventas.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.upeu.ventas.dao.PersonaDAO;
import edu.upeu.ventas.dao.impl.PersonaDAOJdbcImpl;
import edu.upeu.ventas.dominio.Persona;
import edu.upeu.ventas.service.PersonaService;
import edu.upeu.ventas.web.form.PersonaForm;

public class PersonaServiceImpl implements PersonaService {

	PersonaDAO personaDAO = new PersonaDAOJdbcImpl();

	public List<PersonaForm> getListaPersonas() {

		List<PersonaForm> l = new ArrayList<PersonaForm>();

		List<Persona> lista = personaDAO.listarPersonas();
		System.out.println("Lista devuelta :" +lista.size());
		
		for (Persona p : lista) {
			PersonaForm pf = new PersonaForm();
			pf.setId(p.getId());
			pf.setNombre(p.getNombre());
			pf.setApePat(p.getApePat());
			pf.setApeMat(p.getApeMat());

			l.add(pf);
		}

		return l;
	}

}
