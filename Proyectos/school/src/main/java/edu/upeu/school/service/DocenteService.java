package edu.upeu.school.service;

import java.util.List;

import edu.upeu.school.web.form.DocenteForm;

public interface DocenteService {

	List<DocenteForm> getListaDocentes();

	void guardarDocente(DocenteForm df);

	DocenteForm getDocentePorId(String id);

}
