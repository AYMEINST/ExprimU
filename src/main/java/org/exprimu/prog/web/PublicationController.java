package org.exprimu.prog.web;

import java.util.List;

import org.exprimu.prog.entity.Document;
import org.exprimu.prog.entity.Publication;
import org.exprimu.prog.metierImp.PublicationMetierImp;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Publication")
public class PublicationController {
	private PublicationMetierImp publicationMetierI;

	public Page<Publication> publicationPage(int page, int size) {
		return publicationMetierI.publicationPage(page, size);
	}

	public List<Publication> publicationList() {
		return publicationMetierI.publicationList();
	}

	public Publication getPublication(Long id) {
		return publicationMetierI.getPublication(id);
	}

    @RequestMapping( name="/Poblication/save" ,method=RequestMethod.POST )
	public Publication save(Publication publication, Document document) {
		return publicationMetierI.save(publication, document);
	}

	public void delete(Long id) {
		publicationMetierI.delete(id);
	}

}
