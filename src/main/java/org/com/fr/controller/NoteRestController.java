package org.com.fr.controller;

import java.util.List;

import org.com.fr.entity.NotePublication;
import org.com.fr.metierInterface.Note_publicationMetierI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteRestController {
	@Autowired
	private Note_publicationMetierI notePublication;
	private Long idUtilisateur ;

	 @RequestMapping(value="/GetListNote",method=RequestMethod.GET)
	public List<NotePublication> note_publicationList() {
		return notePublication.note_publicationList();
	}
	 @RequestMapping(value="/GetoNote/{id}",method=RequestMethod.GET)
	public NotePublication getNote_Publication(@PathVariable Long id) {
		return notePublication.getNote_Publication(id);
	}
	  @RequestMapping(value="/note",method = RequestMethod.POST)
	public NotePublication save(@RequestBody NotePublication note_publication) {
		  System.out.println("in");
//		return notePublication.save(note_publication);
		  return note_publication;
	
	}
	  @RequestMapping(value="/note/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		notePublication.delete(id);
	}

	  
	  
	public Long getUserConnect(){
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	         idUtilisateur = authentication.getName();
//		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//		    String currentUserName = authentication.getName();
//		    return currentUserName;
//		}
		
		return idUtilisateur;
	}
}
