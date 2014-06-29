package edu.upeu.ventas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import edu.upeu.ventas.dao.DocenteDAO;
import edu.upeu.ventas.dao.hibernate.impl.DocenteDAOHibernateImpl;
import edu.upeu.ventas.dominio.Docente;
import edu.upeu.ventas.service.DocenteService;
import edu.upeu.ventas.web.form.DocenteForm;

public class DocenteServiceImpl implements DocenteService {

	DocenteDAO docenteDAO = new DocenteDAOHibernateImpl();

	public List<DocenteForm> listar() {

		List<DocenteForm> l = new ArrayList<DocenteForm>();

		List<Docente> lista = docenteDAO.listar();

		for (Docente p : lista) {
			DocenteForm pf = new DocenteForm();
<<<<<<< HEAD
			pf.setId(p.getId() + "");
=======
			pf.setId(p.getId().toString());
>>>>>>> branch 'master' of https://github.com/jsempai/UPeU-LP2.git
			pf.setNombre(p.getNombre());
			pf.setApePat(p.getApePat());
			pf.setApeMat(p.getApeMat());

			l.add(pf);
		}

		return l;
	}

	public void guardar(DocenteForm df) {
		Docente d = new Docente();
		d.setApePat(df.getApePat());
		d.setApeMat(df.getApeMat());
		d.setNombre(df.getNombre());

		if (StringUtils.isEmpty(df.getId())) {
			docenteDAO.insertar(d);
		} else {
			d.setId(new Long(df.getId()));
			docenteDAO.actualizar(d);
		}

	}

	public DocenteForm getDocentePorId(String id) {
		DocenteForm df = new DocenteForm();
		Docente d = docenteDAO.getDocentePorId(id);

		if (d != null) {
<<<<<<< HEAD
			df.setId(d.getId() + "");
=======
			df.setId(d.getId().toString());
>>>>>>> branch 'master' of https://github.com/jsempai/UPeU-LP2.git
			df.setNombre(d.getNombre());
			df.setApePat(d.getApePat());
			df.setApeMat(d.getApeMat());
		}

		return df;
	}
}
