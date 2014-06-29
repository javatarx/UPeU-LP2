package edu.upeu.ventas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import edu.upeu.ventas.dao.CursoDAO;
import edu.upeu.ventas.dao.hibernate.impl.CursoDAOHibernateImpl;
import edu.upeu.ventas.dominio.Alumno;
import edu.upeu.ventas.dominio.Curso;
import edu.upeu.ventas.service.CursoService;
import edu.upeu.ventas.web.form.CursoForm;

public class CursoServiceImpl implements CursoService {
	CursoDAO cursoDAO = new CursoDAOHibernateImpl();

	public List<CursoForm> listar() {
		List<CursoForm> lista = new ArrayList<CursoForm>();
		List<Curso> cursos = cursoDAO.listar();
		for (Curso curso : cursos) {
			CursoForm cf = new CursoForm();

			cf.setId(curso.getId().toString());
			cf.setNombre(curso.getNombre());
			cf.setNroCreditos(curso.getNroCreditos() + "");
			cf.setNroHoras(curso.getNroHoras() + "");
			lista.add(cf);
		}

		return lista;
	}

	public void guardar(CursoForm p) {
		Curso c = new Curso();
		c.setNombre(p.getNombre());
		c.setNroHoras(new Integer(p.getNroHoras()));
		c.setNroCreditos(new Integer(p.getNroCreditos()));

		if (StringUtils.isEmpty(p.getId())) {
			cursoDAO.insertar(c);
		} else {
			c.setId(new Long(p.getId()));
			cursoDAO.actualizar(c);
		}

	}

	public CursoForm getCursoPorId(String id) {
		Curso curso = cursoDAO.getCursoPorId(id);
		CursoForm cf = new CursoForm();
		cf.setId(curso.getId().toString());
		cf.setNombre(curso.getNombre());
		cf.setNroCreditos(curso.getNroCreditos() + "");
		cf.setNroHoras(curso.getNroHoras() + "");

		return cf;
	}

	public List<CursoForm> listarCursosAlumno(String id) {
		List<CursoForm> lista = new ArrayList<CursoForm>();
		List<Curso> cursos = cursoDAO.listar();
		Alumno alumno = new Alumno();
		alumno.setId(new Long(id));

		for (Curso curso : cursos) {
			CursoForm cf = new CursoForm();

			if (curso.getAlumnos().contains(alumno)) {
				cf.setChecked("checked='checked'");
			}

			cf.setId(curso.getId().toString());
			cf.setNombre(curso.getNombre());
			cf.setNroCreditos(curso.getNroCreditos() + "");
			cf.setNroHoras(curso.getNroHoras() + "");
			lista.add(cf);
		}

		return lista;
	}

}
