package edu.upeu.school.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.upeu.school.service.AlumnoService;
import edu.upeu.school.web.form.AlumnoForm;

@Controller
@RequestMapping(value = "/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

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
	public String guardarAlumno(@ModelAttribute AlumnoForm af,
			BindingResult result, Model model) {
		alumnoService.guardarAlumno(af);
		return "redirect:/alumnos/";
	}
}
