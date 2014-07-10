package edu.upeu.school.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.upeu.school.service.AlumnoService;
import edu.upeu.school.service.CursoService;
import edu.upeu.school.web.form.AlumnoForm;

@Controller
@RequestMapping(value = "/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private CursoService cursoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listarAlumnos(Model model) {
		List<AlumnoForm> lista = alumnoService.listarAlumnos();
		model.addAttribute("lp", lista);
		return "alumno/main";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String mostrarFormularioNuevoAlumno(Model model) {
		AlumnoForm alumno = new AlumnoForm();
		model.addAttribute("alumno", alumno);
		return "alumno/formulario";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public String guardarAlumnoNuevo(@ModelAttribute AlumnoForm af,
			BindingResult result, Model model) {
		alumnoService.guardarAlumno(af);
		return "redirect:/alumnos/";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String mostrarFormularioAlumno(@PathVariable String id, Model model) {
		AlumnoForm alumno = alumnoService.getAlumnoPorId(id);
		model.addAttribute("alumno", alumno);

		return "alumno/formulario";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String actualizarAlumno(@PathVariable String id,
			@ModelAttribute AlumnoForm af, Model model) {
		alumnoService.guardarAlumno(af);

		return "redirect:/alumnos/";
	}

	@RequestMapping(value = "/{id}/cursos", method = RequestMethod.GET)
	public String mostrarFormularioCursoAlumno(@PathVariable String id, Model model) {
		AlumnoForm alumno = alumnoService.getAlumnoPorId(id);
		model.addAttribute("alumno", alumno);

		return "alumno/formulario";
	}
}
