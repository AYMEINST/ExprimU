package org.exprimu.prog.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/Admin")
public class AdminController {
	
    @Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/index")
	public String index(Model model) {
		return "admin/index";
	}

//	@RequestMapping(value = "/Forum")
//    @Secured(value = { "ROLE_USER","ROLE_ADMIN" })
//	@RequestMapping(value = "/utilisateurt")
//	public String utilisateurt(Model model) {
//		return "utilisateurt";
//	}
//    
//    @Secured(value={"ROLE_USER"})
//	@RequestMapping(value="/utilisateurTempon")
//	public String formut(Model model){
//		return "utilisateurt";	
//	}
    
    @Secured(value={"ROLE_ADMIN"})
    @RequestMapping(value="/admin")
    public String admin(Model model){
    	return "admin/index";
    }
    
    @Secured(value={"ROLE_ADMIN"})
    @RequestMapping(value="/listUserTmp")
    public String utilisateurtamp(Model model){
    	return "admin/gestionutilisateurstampon";
    }
    
    @Secured(value={"ROLE_ADMIN"})
    @RequestMapping(value="/listUser")
    public String utilisateur(Model model){
    	return "admin/gestionutilisateurs";
    }
	                                                                                                                                                                                                                                                                                                     
}
