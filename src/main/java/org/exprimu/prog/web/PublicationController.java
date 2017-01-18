package org.exprimu.prog.web;

import java.util.List;

import org.exprimu.prog.entity.Document;
import org.exprimu.prog.entity.Publication;
import org.exprimu.prog.metierImp.PublicationMetierImp;
//import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Publication")
public class PublicationController {
	private PublicationMetierImp publicationMetierI;

//	public Page<Publication> publicationPage(int page, int size) {
//		return publicationMetierI.publicationPage(page, size);
//	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Publication> publicationList() {
		return publicationMetierI.publicationList();
	}

	@RequestMapping(value = "/getPublication/{id}", method = RequestMethod.GET)
	public Publication getPublication(@PathVariable(value="id") Long id) {
		return publicationMetierI.getPublication(id);
	}

	@RequestMapping(value = "/SavePublication", method = RequestMethod.POST)
	public Publication save(@RequestBody Publication publication,@RequestBody Document document) {
		return publicationMetierI.save(publication, document);
	}
	
	 @RequestMapping( value="/Delete/{id}" ,method=RequestMethod.DELETE )
	public void delete(@PathVariable(value="id") Long id) {
		publicationMetierI.delete(id);
	}

}
