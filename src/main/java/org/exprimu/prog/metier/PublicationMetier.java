package org.exprimu.prog.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.exprimu.prog.dao.DocumentRepository;
import org.exprimu.prog.dao.PublicationRepository;
import org.exprimu.prog.dao.UtilisateurRepository;
import org.exprimu.prog.entity.Document;
import org.exprimu.prog.entity.Publication;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metierImp.PublicationMetierImp;

@Service
public class PublicationMetier implements PublicationMetierImp {
	@Autowired
	private PublicationRepository publicationRepository;
	@Autowired
	private DocumentRepository documentRepository;
	
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
	@Transactional
	public void delete(Long id) {
		publicationRepository.delete(publicationRepository.findOne(id));
	}


	@Override
	@Transactional
	public void updatePublication(Long idPublication ,String statue,String tritrePublication,String DescriptifDocument ,Long idFichier ) {
     Publication P = publicationRepository.getOne(idPublication);
     Document    D = documentRepository.getOne(P.getIdPublication());
		P.setDatePublication(new Date());
		P.setTitrePublication(tritrePublication);
		P.setStatuePublication(statue);
		D.setDateCreation(new Date());
		D.setDescriptionFichier(DescriptifDocument);
		D.setIdFichier(idFichier);
		publicationRepository.save(P);
		documentRepository.save(D);	
	}

	@Override
	public Publication save(Publication publication) {
		publication.setDatePublication(new Date());		
		return publicationRepository.save(publication);
	}
	
	
	
}
