package edu.upeu.ventas.dao.hibernate.impl;

import java.util.List;

<<<<<<< HEAD
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import edu.upeu.ventas.dao.AlumnoDAO;
import edu.upeu.ventas.dominio.Alumno;
import edu.upeu.ventas.dominio.Curso;
import edu.upeu.ventas.util.HibernateUtil;

public class AlumnoDAOHibernateImpl implements AlumnoDAO {
	private SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
	private Session session = null;

	public void insertar(Alumno p) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Alumno> listar() {
		session = sessionFactory.openSession();
		List<Alumno> lista = session.createCriteria(Alumno.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.close();
		return lista;
	}

	public Alumno getAlumnoPorId(String id) {
		session = sessionFactory.openSession();
		Alumno a = (Alumno) session.createCriteria(Alumno.class)
				.add(Restrictions.idEq(new Long(id))).uniqueResult();
		session.close();
		return a;
	}

	public void actualizar(Alumno alumno) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(alumno);
		session.getTransaction().commit();
		session.close();

	}

	public void eliminarCursoAlumno(String idAlumno, String idCurso) {
		session = sessionFactory.openSession();

		session.beginTransaction();
		Alumno a = (Alumno) session.createCriteria(Alumno.class)
				.add(Restrictions.idEq(new Long(idAlumno))).uniqueResult();
		for (Curso c : a.getCursos()) {
			if (c.getId().toString().equals(idCurso)) {
				System.out.println("El curso eliminado es:" + c.getNombre());
				a.getCursos().remove(c);
			}
		}
		session.update(a);
		session.getTransaction().commit();

		session.close();
=======
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import edu.upeu.ventas.dao.AlumnoDAO;
import edu.upeu.ventas.dominio.Alumno;
import edu.upeu.ventas.util.HibernateUtil;

public class AlumnoDAOHibernateImpl implements AlumnoDAO {
	private SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
	private Session session = null;

	public void insertar(Alumno p) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Alumno> listar() {
		session = sessionFactory.openSession();
		List<Alumno> lista = session.createCriteria(Alumno.class).list();
		session.close();
		return lista;
	}

	public Alumno getAlumnoPorId(String id) {
		session = sessionFactory.openSession();
		Alumno a = (Alumno) session.createCriteria(Alumno.class)
				.add(Restrictions.idEq(new Long(id))).uniqueResult();
		session.close();
		return a;
	}

	public void actualizar(Alumno alumno) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(alumno);
		session.getTransaction().commit();
		session.close();

>>>>>>> branch 'master' of https://github.com/jsempai/UPeU-LP2.git
	}
}
