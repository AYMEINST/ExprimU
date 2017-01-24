package org.exprimu.prog.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/Index")
public class IndexController {
	
	@RequestMapping(value = "/index")
	public String index(Model model) {
		return "index";
	}

//	@RequestMapping(value = "/Forum")
    @Secured(value = { "ROLE_USER","ROLE_ADMIN" })
	@RequestMapping(value = "/utilisateurt")
	public String utilisateurt(Model model) {
		return "utilisateurt";
	}

	                                                                                                                                                                                                                                                                                                     
}
