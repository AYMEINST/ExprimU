package org.exprimu.prog.web;

import java.util.Date;
import java.util.List;

import org.exprimu.prog.entity.NotePublication;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metierImp.NotePublicationMetierImp;
import org.exprimu.prog.metierImp.PublicationMetierImp;
import org.exprimu.prog.metierImp.UtilisateurMetierImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="Vote")
public class NoteController {
	@Autowired
	private NotePublicationMetierImp notePublication;
	@Autowired
	private UtilisateurMetierImp utilisateurMetier;
	@Autowired
	private PublicationMetierImp publicationMetier;

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	public Page<NotePublication> notepublicationPage(int page, int size) {
		return notePublication.notepublicationPage(page, size);
	}
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value="/allVote", method = RequestMethod.GET)
	public List<NotePublication> notepublicationList() {
		return notePublication.notepublicationList();
	}
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value="/getOne/{id}", method = RequestMethod.GET)
	public NotePublication getNotePublication( @RequestParam(name = "id", defaultValue = "0") Long id) {
		return notePublication.getNotePublication(id);
	}
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestParam(name = "id", defaultValue = "0") Long id) {
		notePublication.delete(id);
	}
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public NotePublication save(@RequestBody NotePublication notepublication ,@RequestParam(name = "idPublication", defaultValue = "0") Long  idPublication) {
		notepublication.setDateAppreciation(new Date());
		notepublication.getListutilisateur().add((Utilisateur) utilisateurMetier.getConnectedUser().get("idUtilisateur"));
		notepublication.setIdPublication(publicationMetier.getPublication(idPublication));
		return notePublication.save(notepublication);
	}
	
	
	

}
