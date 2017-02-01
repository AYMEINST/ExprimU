package org.exprimu.prog.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.websocket.server.PathParam;

import org.exprimu.prog.dao.UtilisateurTempRepository;
import org.exprimu.prog.entity.UtilisateurTemp;
import org.exprimu.prog.metier.UtilisateurTempMetier;
import org.exprimu.prog.metierImp.UtilisateurTempMetierImp;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/utilisateurt")
public class UtilisateurTempController {
	@Autowired
	private UtilisateurTempMetierImp utilisateurTempMetierImp;

	// ajouter un utilisateur temporaire

	@Secured(value = { "ROLE_USER", "ROLE_ADMIN" })
	@RequestMapping(value = "/saveut", method = RequestMethod.POST)
	public Map<String, Boolean> saveulisateurtemp(@RequestBody UtilisateurTemp ut) {

		boolean utp = utilisateurTempMetierImp.rechercherbymail(ut.getEmailUtilisateurTemp());
		Map<String, Boolean> m =new HashMap<>();
		// System.out.println("mail existe ");
		// boolean utp = true;
		if (utp == true) {
			System.out.println("ce utilisateur est deja existe sur le system");
			m.put("succ", true);
			return m;
		}
		else if(utp==false){
		 System.out.println("ce utilisateur non existe sur le system");
			utilisateurTempMetierImp.save(ut);
			m.put("succ", false);
		return m;
		}
		return m;
	}

	// lister tout les utilisateur temporaire

	@Secured(value = { "ROLE_ADMIN" })
	@RequestMapping(value = "/utilisateurtempList", method = RequestMethod.GET)
	public List<UtilisateurTemp> utilisateurtempList() {
		return utilisateurTempMetierImp.utilisateurtempList();
	}

	// @Secured(value={"ROLE_USER"})
	// @RequestMapping(value="/verifiermail",method=RequestMethod.GET)
	// public String verifiermail(){
	//
	// return "";
	// }

}
