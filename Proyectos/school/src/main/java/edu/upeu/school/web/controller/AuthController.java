package edu.upeu.school.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(
			@RequestParam(value = "error", required = false) boolean error,
			Model model) {

		if (error == true) {
			model.addAttribute("error",
					"Ingrese un usuario o contrase&ntilde;a v&aacute;lido");
		}

		return "auth/login";
	}

	@RequestMapping(value = "/denegado", method = RequestMethod.GET)
	public String getPaginaDenegado() {

		return "auth/denegado";
	}

}
