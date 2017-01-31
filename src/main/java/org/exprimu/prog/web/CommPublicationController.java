package org.exprimu.prog.web;

import java.util.Date;
import java.util.List;


import org.exprimu.prog.entity.Commentaire;
import org.exprimu.prog.entity.Publication;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metier.CommentaireMetier;
import org.exprimu.prog.metier.PublicationMetier;
import org.exprimu.prog.metierImp.UtilisateurMetierImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/Commentaire")
public class CommPublicationController {
	@Autowired
	private CommentaireMetier  commentaireMetier;
	@Autowired
	private UtilisateurMetierImp UtilisateurMetier;
	@Autowired
	private PublicationMetier PublicationMetier;



	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Commentaire> commentaireList() {
		return commentaireMetier.commentaireList();
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Commentaire getCommentaire(@PathVariable Long id) {
		return commentaireMetier.getCommentaire(id);
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Save", method = RequestMethod.POST)
	public Commentaire save( @RequestParam String contenuCommenatire ,@RequestParam Long idPublication) {
		Commentaire commentaire =new Commentaire();
		commentaire.setUtilisateur((Utilisateur) UtilisateurMetier.getConnectedUser().get("utilisateur"));
		commentaire.setDateCommentaire(new Date());
		commentaire.setContenuCommentaire(contenuCommenatire);
		commentaire.setPublication(PublicationMetier.getPublication(idPublication));
		return commentaireMetier.save(commentaire);
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping( value = "/Delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		commentaireMetier.delete(id);
	}

}
