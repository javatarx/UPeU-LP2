package edu.upeu.school.dao.impl.hibernate;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.upeu.school.dao.AlumnoDAO;
import edu.upeu.school.domain.Alumno;
import edu.upeu.school.domain.Curso;

@Repository
public class AlumnoDAOHibernateImpl extends
		GenericDaoHibernateImpl<Alumno, String> implements AlumnoDAO {

	public void eliminarCursoAlumno(String idAlumno, String idCurso) {
		Alumno a = (Alumno) getSession().createCriteria(Alumno.class)
				.add(Restrictions.idEq(new Long(idAlumno))).uniqueResult();
		for (Curso c : a.getCursos()) {
			if (c.getId().toString().equals(idCurso)) {
				a.getCursos().remove(c);
			}
		}
	}
}
