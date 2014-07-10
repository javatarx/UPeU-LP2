package edu.upeu.school.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "DOCENTE_CURSO")
public class DocenteCurso {

	@Id
	@GeneratedValue(generator = "genId")
	@GenericGenerator(name = "genId", strategy = "edu.upeu.school.util.GeneradorIDRandom")
	@Column(name = "ID_DOCENTE_CURSO")
	private String id;
	@JoinColumn(name = "ID_CURSO")
	@ManyToOne(optional = true)
	private Curso curso;
	@JoinColumn(name = "ID_DOCENTE")
	@ManyToOne(optional = true)
	private Docente docente;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}
