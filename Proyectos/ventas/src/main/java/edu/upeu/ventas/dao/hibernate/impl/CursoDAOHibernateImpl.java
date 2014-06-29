package edu.upeu.ventas.dao.hibernate.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import edu.upeu.ventas.dao.CursoDAO;
import edu.upeu.ventas.dominio.Curso;
import edu.upeu.ventas.util.HibernateUtil;

public class CursoDAOHibernateImpl implements CursoDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
	private Session session;

	public void insertar(Curso c) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
	}

	public List<Curso> listar() {
		session = sessionFactory.openSession();
		List<Curso> lista = session.createCriteria(Curso.class).list();
		session.close();
		return lista;
	}

	public Curso getCursoPorId(String id) {
		session = sessionFactory.openSession();
		Curso c = (Curso) session.createCriteria(Curso.class)
				.add(Restrictions.idEq(new Long(id))).uniqueResult();
		session.close();
		return c;
	}

	public void actualizar(Curso c) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(c);
		session.getTransaction().commit();
		session.close();
	}

}
