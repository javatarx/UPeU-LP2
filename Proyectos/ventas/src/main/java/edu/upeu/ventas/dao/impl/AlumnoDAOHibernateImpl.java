package edu.upeu.ventas.dao.impl;

import java.util.List;

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

	}
}
