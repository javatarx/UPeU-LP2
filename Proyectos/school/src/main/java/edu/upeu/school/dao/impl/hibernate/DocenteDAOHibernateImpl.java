package edu.upeu.school.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import edu.upeu.school.dao.DocenteDAO;
import edu.upeu.school.domain.Docente;

@Repository
public class DocenteDAOHibernateImpl extends
		GenericDaoHibernateImpl<Docente, String> implements DocenteDAO {

}
