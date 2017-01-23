package org.exprimu.prog.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.exprimu.prog.entity.Document;
import org.exprimu.prog.entity.Publication;
import org.exprimu.prog.metierImp.DocumentMetierImp;
import org.exprimu.prog.metierImp.PublicationMetierImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Publication")
public class PublicationController {
	
	@Autowired
	private PublicationMetierImp publicationMetierI;
	@Autowired
	private DocumentMetierImp documentMetierI;
	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	public Page<Publication> publicationPage(int page, int size) {
		return publicationMetierI.publicationPage(page, size);
	}
	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public String publicationList(Model model) {
		 model.addAttribute("messages", publicationMetierI.publicationList());
		 return"";
	}
	
	@Secured(value = {"ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Publication getPublication(@RequestParam(name = "id", defaultValue = "0") Long id) {
		return publicationMetierI.getPublication(id);
	}
	
	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value="/Delete/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestParam(name = "id", defaultValue = "0") Long id) {
		publicationMetierI.delete(id);
	}
	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value="/Update", method = RequestMethod.PUT)
	public void updatePublication(@RequestParam(name = "idPublication", defaultValue = "0") Long idPublication,@RequestParam String statue,@RequestParam String tritrePublication,
			String DescriptifDocument, Long idFichier) {
		publicationMetierI.updatePublication(idPublication, statue, tritrePublication, DescriptifDocument, idFichier);
	}

	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Save", method = RequestMethod.POST)
	public String CreatePublication (@Valid   Publication publication ,  @Valid Document document ,BindingResult BindingResult){
		
		if (BindingResult.hasErrors()){
			return "MyProfile";
		}
//		publication.setUtilisateur();
		Publication P= publicationMetierI.save(publication);
		document.setPublication(P);
		documentMetierI.save(document);
		return "MyProfile";
	}


}
