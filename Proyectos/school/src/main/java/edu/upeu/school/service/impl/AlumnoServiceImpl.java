package edu.upeu.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.upeu.school.dao.AlumnoDAO;
import edu.upeu.school.domain.Alumno;
import edu.upeu.school.service.AlumnoService;
import edu.upeu.school.web.form.AlumnoForm;

@Service
@Transactional(readOnly = true)
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoDAO alumnoDAO;

	public List<AlumnoForm> listarAlumnos() {

		List<AlumnoForm> l = new ArrayList<AlumnoForm>();

		List<Alumno> lista = alumnoDAO.getAll(Alumno.class);

		for (Alumno p : lista) {
			AlumnoForm pf = new AlumnoForm();
			pf.setId(p.getId().toString());
			pf.setNombre(p.getNombre());
			pf.setApePat(p.getApePat());
			pf.setApeMat(p.getApeMat());

			l.add(pf);
		}

		return l;
	}

	@Transactional(readOnly = false)
	public void guardarAlumno(AlumnoForm af) {
		Alumno alumno = new Alumno();
		alumno.setApePat(af.getApePat());
		alumno.setApeMat(af.getApeMat());
		alumno.setNombre(af.getNombre());

		if (StringUtils.isEmpty(af.getId())) {
			alumnoDAO.insert(alumno);
		} else {
			alumno.setId(new Long(af.getId()));
			alumnoDAO.update(alumno);
		}

	}

}
