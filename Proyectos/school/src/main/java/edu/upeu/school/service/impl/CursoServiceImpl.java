package edu.upeu.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.upeu.school.dao.CursoDAO;
import edu.upeu.school.domain.Alumno;
import edu.upeu.school.domain.Curso;
import edu.upeu.school.service.CursoService;
import edu.upeu.school.web.form.CursoForm;

@Service
@Transactional(readOnly = true)
public class CursoServiceImpl implements CursoService {
	@Autowired
	private CursoDAO cursoDAO;

	public List<CursoForm> listar() {
		List<CursoForm> lista = new ArrayList<CursoForm>();
		List<Curso> cursos = cursoDAO.getAll(Curso.class);
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

	@Transactional(readOnly = false)
	public void guardar(CursoForm p) {
		Curso c = new Curso();
		c.setNombre(p.getNombre());
		c.setNroHoras(new Integer(p.getNroHoras()));
		c.setNroCreditos(new Integer(p.getNroCreditos()));

		if (StringUtils.isEmpty(p.getId())) {
			cursoDAO.insert(c);
		} else {
			c.setId(p.getId());
			cursoDAO.update(c);
		}

	}

	public CursoForm getCursoPorId(String id) {
		Curso curso = cursoDAO.findByPK(Curso.class, id);
		CursoForm cf = new CursoForm();
		cf.setId(curso.getId().toString());
		cf.setNombre(curso.getNombre());
		cf.setNroCreditos(curso.getNroCreditos() + "");
		cf.setNroHoras(curso.getNroHoras() + "");

		return cf;
	}

	public List<CursoForm> listarCursosAlumno(String id) {
		List<CursoForm> lista = new ArrayList<CursoForm>();
		List<Curso> cursos = cursoDAO.getAll(Curso.class);
		Alumno alumno = new Alumno();
		alumno.setId(id);

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
