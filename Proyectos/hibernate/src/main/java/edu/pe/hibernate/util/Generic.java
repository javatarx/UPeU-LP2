package edu.pe.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Generic<T> {

	public static SessionFactory getSessionFactory() {
		return HibernateUtil.getSessionfactory();
	}

	private T entidad;
	private Session session;

	public void iniciarTransaccion() {
		session = Generic.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	}

	public void commit() {
		session.getTransaction().commit();
	}

	public Generic(T entidad) {
		this.entidad = entidad;
	}

	public void actualizar(T entidad) {
		session.update(entidad);
	}

	public void insertar(T entidad) {
		session.save(entidad);
	}
	
	public void eliminar(T entidad) {
		session.delete(entidad);
	}

}
