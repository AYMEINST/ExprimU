package org.com.fr.security;

import org.com.fr.entity.Utilisateur;
import org.com.fr.metierInterface.UtilisateurMetierI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@Autowired
	private UtilisateurMetierI utilisateurMetier;

//	@RequestMapping(value = "/login")
//	public String AppLogin() {
//		return "login";
//	}
//	

	

}
