package edu.upeu.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.upeu.school.dao.CursoDAO;
import edu.upeu.school.dao.DocenteCursoDAO;
import edu.upeu.school.dao.DocenteDAO;
import edu.upeu.school.domain.Curso;
import edu.upeu.school.domain.Docente;
import edu.upeu.school.domain.DocenteCurso;
import edu.upeu.school.service.DocenteService;
import edu.upeu.school.web.form.CursoForm;
import edu.upeu.school.web.form.DocenteForm;

@Service
@Transactional(readOnly = true)
public class DocenteServiceImpl implements DocenteService {

	@Autowired
	private DocenteDAO docenteDAO;
	@Autowired
	private DocenteCursoDAO docenteCursoDAO;
	@Autowired
	private CursoDAO cursoDAO;

	public List<DocenteForm> getListaDocentes() {

		List<DocenteForm> lf = new ArrayList<DocenteForm>();

		List<Docente> lista = docenteDAO.getAll(Docente.class);

		for (Docente d : lista) {
			DocenteForm df = new DocenteForm();
			df.setId(d.getId());
			df.setNombre(d.getNombre());
			df.setApePat(d.getApePat());
			df.setApeMat(d.getApeMat());

			lf.add(df);
		}

		return lf;
	}

	@Transactional(readOnly = false)
	public void guardarDocente(DocenteForm df) {
		Docente d = new Docente();
		d.setApePat(df.getApePat());
		d.setApeMat(df.getApeMat());
		d.setNombre(df.getNombre());

		if (StringUtils.isEmpty(df.getId())) {
			docenteDAO.insert(d);
		} else {
			d.setId(df.getId());
			docenteDAO.update(d);
		}
	}

	public DocenteForm getDocentePorId(String id) {
		DocenteForm df = new DocenteForm();
		Docente d = docenteDAO.findByPK(Docente.class, id);

		if (d != null) {
			df.setId(d.getId().toString());
			df.setNombre(d.getNombre());
			df.setApePat(d.getApePat());
			df.setApeMat(d.getApeMat());
		}

		return df;
	}

	@Override
	public DocenteForm getDocenteCursosPorId(String id) {

		DocenteForm df = new DocenteForm();

		Docente d = docenteDAO.findByPK(Docente.class, id);

		if (d != null) {
			df.setId(d.getId());
			df.setNombre(d.getNombre());
			df.setApePat(d.getApePat());
			df.setApeMat(d.getApeMat());

			List<CursoForm> ldc = new ArrayList<CursoForm>();

			for (DocenteCurso dc : d.getCursos()) {
				CursoForm cf = new CursoForm();
				cf.setId(dc.getCurso().getId());
				cf.setNombre(dc.getCurso().getNombre());

				ldc.add(cf);
			}

			df.setCursos(ldc);

		}

		return df;
	}

	@Override
	public void guardarCursosDocente(DocenteForm df) {
		// TODO Auto-generated method stub

	}

	@Override
	public DocenteForm getDocenteAllCursosPorId(String id) {

		List<Curso> cursos = cursoDAO.getAll(Curso.class);
		DocenteForm df = new DocenteForm();

		Docente d = docenteDAO.findByPK(Docente.class, id);

		if (d != null) {
			df.setId(d.getId());
			df.setNombre(d.getNombre());
			df.setApePat(d.getApePat());
			df.setApeMat(d.getApeMat());

			List<CursoForm> ldc = new ArrayList<CursoForm>();

			// hago el recorrido de la lista de cursos
			for (Curso c : cursos) {
				CursoForm cf = new CursoForm();
				cf.setId(c.getId());
				cf.setNombre(c.getNombre());
				cf.setNroCreditos(c.getNroCreditos() + "");
				cf.setNroHoras(c.getNroHoras() + "");

				// verifico si el curso actual esta contenido dentro de los
				// cursos que ensenia el docente
				for (DocenteCurso cc : d.getCursos()) {
					if (cc.getCurso().equals(c)) {
						cf.setChecked("checked='checked'");
					}

				}

				ldc.add(cf);
			}

			df.setCursos(ldc);

		}

		return df;
	}

	@Transactional(readOnly = false)
	public void guardarCursosDocente(String id, String[] ids) {
		Docente d = new Docente();
		d.setId(id);
		List<DocenteCurso> ldc = docenteCursoDAO.getAllRestrictionEQ(
				DocenteCurso.class, "docente.id", id);
		for (DocenteCurso dc : ldc) {
			docenteCursoDAO.remove(dc);
		}

		for (String i : ids) {
			DocenteCurso dc = new DocenteCurso();
			Curso c = new Curso();
			c.setId(i);
			dc.setCurso(c);
			dc.setDocente(d);
			docenteCursoDAO.insert(dc);
		}
	}
}
