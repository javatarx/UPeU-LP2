package edu.upeu.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.upeu.school.dao.DocenteCursoDAO;
import edu.upeu.school.dao.DocenteDAO;
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
	public void guardarDocenteCursos(DocenteForm df) {
		// TODO Auto-generated method stub

	}
}
