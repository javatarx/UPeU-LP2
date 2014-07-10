package edu.upeu.school.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import edu.upeu.school.dao.DocenteCursoDAO;
import edu.upeu.school.domain.DocenteCurso;

@Repository
public class DocenteCursoDAOHibernateImpl extends GenericDaoHibernateImpl<DocenteCurso, String> implements DocenteCursoDAO {

}
