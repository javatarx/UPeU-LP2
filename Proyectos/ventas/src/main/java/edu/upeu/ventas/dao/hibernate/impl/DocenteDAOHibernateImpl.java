package edu.upeu.ventas.dao.hibernate.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import edu.upeu.ventas.dao.DocenteDAO;
import edu.upeu.ventas.dominio.Docente;
import edu.upeu.ventas.util.HibernateUtil;

public class DocenteDAOHibernateImpl implements DocenteDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
	private Session session = null;

	@SuppressWarnings("unchecked")
	public List<Docente> listar() {
		session = sessionFactory.openSession();
		List<Docente> lista = session.createCriteria(Docente.class).list();
		session.close();

		return lista;
	}

	public Docente getDocentePorId(String id) {

		session = sessionFactory.openSession();
		Docente d = (Docente) session.createCriteria(Docente.class)
				.add(Restrictions.idEq(new Long(id))).uniqueResult();
		session.close();
		return d;
	}

	public void insertar(Docente d) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		session.close();
	}

	public void actualizar(Docente d) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(d);
		session.getTransaction().commit();
		session.close();
	}

}
