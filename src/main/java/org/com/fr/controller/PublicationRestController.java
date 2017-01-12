package org.com.fr.controller;


import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import org.com.fr.entity.Element_publication;
import org.com.fr.entity.Publication;
import org.com.fr.metierImpl.PublicationMetier;
import org.com.fr.metierInterface.PublicationMetierI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicationRestController {
	@Autowired
	private PublicationMetierI publicationMetier;

	 @RequestMapping(value="/GetListPublication",method=RequestMethod.GET)
	public List<Publication> publicationList() {
		return publicationMetier.publicationList();
	}
	 @RequestMapping(value="/GetoPublication/{id}",method=RequestMethod.GET)
	public Publication getPublication(@PathVariable Long id) {
		return publicationMetier.getPublication(id);
	}
    @RequestMapping(value="/editPublication" ,method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		publicationMetier.delete(id);
	}
    @RequestMapping(value="/publication",method = RequestMethod.POST)
	public void publishAdd( @RequestBody Publication publication,@RequestBody Element_publication element_publication) {
		publicationMetier.publishAdd(publication, element_publication);
	}

	


}
