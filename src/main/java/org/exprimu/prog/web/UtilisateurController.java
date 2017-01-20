package org.exprimu.prog.web;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.entity.UtilisateurTemp;
import org.exprimu.prog.metier.UtilisateurMetier;
import org.exprimu.prog.metier.UtilisateurTempMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="utilisateur")
public class UtilisateurController {
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	
	@Autowired
	private UtilisateurTempMetier utilisateurTempMetier;

	public Page<Utilisateur> utilisateurPage(int page, int size) {
		return utilisateurMetier.utilisateurPage(page, size);
	}

	public Utilisateur getUtilisateur(Long id) {
		return utilisateurMetier.getUtilisateur(id);
	}
	
	@Transactional
	@RequestMapping(value="saveutilisateur",method=RequestMethod.POST)
	public Utilisateur save(Utilisateur utilisateur,@PathParam(value="id") Long id) {
		UtilisateurTemp utp= utilisateurTempMetier.getUtilisateurTemp(id);
		utilisateur.setNom(utp.getNomUtilisateurTemp());
		utilisateur.setPrenom(utp.getPrenomUtilisateurTemp());
		utilisateur.setEmail(utp.getEmailUtilisateurTemp());
		utilisateur.setPassword(utp.getMotdepasse());
		utilisateurTempMetier.delete(id);
		return utilisateurMetier.save(utilisateur);
	}

	public void delete(Long id) {
		utilisateurMetier.delete(id);
	}
	
	
}
