package edu.pe.hibernate.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import edu.pe.hibernate.util.HibernateUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonaTest {

	private SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
	private Session session = null;

	@Before
	public void setUp() throws Exception {

		session = sessionFactory.openSession();

		Persona p1 = new Persona("Jesus1", "Mariaca1", "Mamani1");
		Persona p2 = new Persona("Jesus2", "Mariaca2", "Mamani2");
		Persona p3 = new Persona("Jesus3", "Mariaca3", "Mamani3");

		session.beginTransaction();

		session.save(p1);
		session.save(p2);
		session.save(p3);

		session.getTransaction().commit();
		session.close();

	}

	@Test
	public void test1ListarPersonas() {

		session = sessionFactory.openSession();
		List<Persona> lista = session.createCriteria(Persona.class).list();
		assertEquals(3, lista.size());
		session.close();

	}

	@Test
	public void test2Insertar() {
		session = sessionFactory.openSession();
		Persona p = new Persona("Nombre1", "Paterno1", "Materno1");
		session.beginTransaction();
		assertNull(p.getId());
		session.save(p);
		assertNotNull(p.getId());
		session.getTransaction().commit();
		session.close();
	}

}
