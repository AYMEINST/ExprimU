
package org.exprimu.prog.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.exprimu.prog.entity.Document;
import org.exprimu.prog.entity.Publication;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metier.PublicationMetier;
import org.exprimu.prog.metierImp.DocumentMetierImp;
import org.exprimu.prog.metierImp.PublicationMetierImp;
import org.exprimu.prog.metierImp.UtilisateurMetierImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Profil")
public class PublicationController {
	
	@Autowired
	private PublicationMetierImp publicationMetierI;
	@Autowired
	private PublicationMetier PublicationMetier;
	@Autowired
	private UtilisateurMetierImp UtilisateurMetier;
	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Save", method = RequestMethod.POST)
	public void savePublication(Publication publication, Document document) {
		PublicationMetier.savePublication(publication, document);
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<Publication> publicationList() {
		return publicationMetierI.publicationList();
	}


	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public Publication getPublication(@PathVariable Long id) {
		return publicationMetierI.getPublication(id);
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/SaveStatue", method = RequestMethod.POST)
	public Publication save( @RequestBody Publication publication) {
		publication.setUtilisateur((Utilisateur) UtilisateurMetier.getConnectedUser().get("utilisateur"));
		return publicationMetierI.save(publication);
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		publicationMetierI.delete(id);
	}


	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Update", method = RequestMethod.PUT)
	public void updatePublication(@RequestParam Long idPublication,@RequestParam String statue, @RequestParam String tritrePublication,
			@RequestParam String DescriptifDocument,@RequestParam Long idFichier) {
		publicationMetierI.updatePublication(idPublication, statue, tritrePublication, DescriptifDocument, idFichier);
	}






	
	
	
	
	


	
	

	
	
	
	
	
	
	
	
	


}