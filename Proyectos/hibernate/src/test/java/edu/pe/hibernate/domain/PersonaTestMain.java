package edu.pe.hibernate.domain;

import org.hibernate.Session;

import edu.pe.hibernate.util.HibernateUtil;

public class PersonaTestMain {

	public static void main(String[] args) {
		PersonaTestMain personaTestMain = new PersonaTestMain();

//		if (args[0].equals("1")) {
			personaTestMain.crearEInsertarPersona("UPeU", "UPeU", "UPeU");
//		}
		HibernateUtil.getSessionfactory().close();
	}

	public void crearEInsertarPersona(String nombre, String apePat,
			String apeMat) {

		Session session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();

		Persona p = new Persona();
		p.setNombre(nombre);
		p.setApellidoPaterno(apePat);
		p.setApellidoMaterno(apeMat);

		session.save(p);

		session.getTransaction().commit();

	}

}
