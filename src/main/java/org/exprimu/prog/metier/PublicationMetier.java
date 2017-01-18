package org.exprimu.prog.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.PublicationRepository;
import org.exprimu.prog.entity.Document;
import org.exprimu.prog.entity.Publication;
import org.exprimu.prog.metierImp.PublicationMetierImp;

@Service
public class PublicationMetier implements PublicationMetierImp {
	@Autowired
	private PublicationRepository publicationRepository;

	@Override
	public Page<Publication> publicationPage(int page, int size) {
		return publicationRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public List<Publication> publicationList() {
		return publicationRepository.findAll();
	}

	@Override
	public Publication getPublication(Long id) {
		return publicationRepository.findOne(id);
	}


	@Override
	public void delete(Long id) {
		publicationRepository.delete(publicationRepository.findOne(id));
	}

	@Override
	public Publication save(Publication publication, Document document) {
		publication.setDatePublication(new Date());
		document.setDateCreation(new Date());
		document.setPublication(publication);
		publication.getListdocument().add(document);
		publicationRepository.save(publication);
		return null;
	}

	@Override
	public void updatePublication(Long id) {
     Publication P = getPublication(id);
     
		
	}
	
	
	
}