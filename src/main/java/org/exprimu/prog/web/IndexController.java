package org.exprimu.prog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/Index")
public class IndexController {
	@RequestMapping(value = "/Etudiant")
	public String etudiant(Model model) {
		return "etudiants";
	}

	@RequestMapping(value = "/Forum")
	public String form(Model model) {
		return "forum";
	}
}
