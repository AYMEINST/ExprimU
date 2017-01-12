package org.com.fr.controller;

import java.util.List;

import org.com.fr.entity.Note_publication;
import org.com.fr.metierInterface.Note_publicationMetierI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteRestController {
	@Autowired
	private Note_publicationMetierI notePublication;

	 @RequestMapping(value="/GetListNote",method=RequestMethod.GET)
	public List<Note_publication> note_publicationList() {
		return notePublication.note_publicationList();
	}
	 @RequestMapping(value="/GetoNote/{id}",method=RequestMethod.GET)
	public Note_publication getNote_Publication(@PathVariable Long id) {
		return notePublication.getNote_Publication(id);
	}
	  @RequestMapping(value="/note",method = RequestMethod.POST)
	public Note_publication save(@RequestBody Note_publication note_publication) {
		  System.out.println("in");
//		return notePublication.save(note_publication);
		  return note_publication;
	
	}
	  @RequestMapping(value="/note/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		notePublication.delete(id);
	}

}