package org.com.fr.metierImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.Element_publicationRepository;
import org.com.fr.entity.Element_publication;
import org.com.fr.metierInterface.Element_publicationMetierI;

@Service
public class Element_publicationMetier implements Element_publicationMetierI {
	@Autowired
	private Element_publicationRepository element_publicationRepository;

	@Override
	public Page<Element_publication> element_publicationPage(int page, int size) {
		return element_publicationRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public List<Element_publication> element_publicationList() {
		return element_publicationRepository.findAll();
	}

	@Override
	public Element_publication getElement_publication(Long id) {
		return element_publicationRepository.findOne(id);
	}

	@Override
	public Element_publication save(Element_publication element_publication) {
		return element_publicationRepository.save(element_publication);
	}

	@Override
	public void delete(Long id) {
		element_publicationRepository.delete(element_publicationRepository.findOne(id));
	}
}
