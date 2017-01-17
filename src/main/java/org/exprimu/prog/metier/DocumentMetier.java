package org.exprimu.prog.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.DocumentRepository;
import org.exprimu.prog.entity.Document;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metierImp.DocumentMetierImp;

@Service
public class DocumentMetier implements DocumentMetierImp {
	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public Page<Document> documentPage(int page, int size) {
		return documentRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public List<Document> documentList() {
		return documentRepository.findAll();
	}

	@Override
	public Document getDocument(Long id) {
		return documentRepository.findOne(id);
	}

	@Override
	public Document save(Document document) {
		
		
		
		return documentRepository.save(document);
	}

	@Override
	public void delete(Long id) {
		documentRepository.delete(documentRepository.findOne(id));
	}

	// get  userId  connect 
	@Override
	public Long getUserConnect() {
		Long userId;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				Utilisateur  customUser = (Utilisateur)authentication.getPrincipal();
				if (!(authentication instanceof AnonymousAuthenticationToken)) {
					 userId = customUser.getIdUtilisateur();	
					 return userId;
				}else{
					return null; // redirection 
				}
		
	}

}
