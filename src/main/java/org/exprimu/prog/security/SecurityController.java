package org.exprimu.prog.security;

import org.exprimu.prog.metier.UtilisateurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SecurityController {

	@Autowired
	private UtilisateurMetier utilisateurMetier;

//	@RequestMapping(value = "/login")
//	public String AppLogin() {
//		return "login";
//	}
//	

	

}
