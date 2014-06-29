package edu.upeu.school.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import edu.upeu.school.dao.CursoDAO;
import edu.upeu.school.domain.Curso;

@Repository
public class CursoDAOHibernateImpl extends
		GenericDaoHibernateImpl<Curso, String> implements CursoDAO {

}
