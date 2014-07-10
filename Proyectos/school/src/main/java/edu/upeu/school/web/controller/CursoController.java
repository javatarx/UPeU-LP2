package edu.upeu.school.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.upeu.school.service.CursoService;
import edu.upeu.school.web.form.CursoForm;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarListaCursos(Model model) {

		List<CursoForm> lista = cursoService.listar();
		model.addAttribute("lp", lista);

		return "curso/main";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String mostrarFormularioCursoNuevo() {
		return "curso/formulario";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public String guardarCursoNuevo(@ModelAttribute CursoForm df) {

		cursoService.guardar(df);

		return "redirect:/cursos/";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String mostrarFormularioCurso(@PathVariable String id, Model model) {

		CursoForm df = cursoService.getCursoPorId(id);
		model.addAttribute("curso", df);

		return "curso/formulario";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String actualizarCurso(@PathVariable String id,
			@ModelAttribute CursoForm df, Model model) {

		cursoService.guardar(df);

		return "redirect:/cursos/";
	}

}
