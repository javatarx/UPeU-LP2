package edu.upeu.school.util;

import java.io.Serializable;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class GeneradorIDRandom implements IdentifierGenerator {

	protected final  Log log  = LogFactory.getLog(getClass());
	
	public Serializable generate(SessionImplementor arg0, Object arg1)
			throws HibernateException {
		Random r=new Random();
		String s=new String(r.nextFloat()+"");
		log.debug("ID Generado: "+s.substring(2));
		return s.substring(2);
	}

}