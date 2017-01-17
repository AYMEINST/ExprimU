package org.com.fr.metierImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.Note_publicationRepository;
import org.com.fr.entity.NotePublication;
import org.com.fr.metierInterface.Note_publicationMetierI;

@Service
public class Note_publicationMetier implements Note_publicationMetierI {
	@Autowired
	private Note_publicationRepository note_publicationRepository;

	@Override
	public Page<NotePublication> note_publicationPage(int page, int size) {
		return note_publicationRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public List<NotePublication> note_publicationList() {
		return note_publicationRepository.findAll();
	}

	@Override
	public NotePublication getNote_Publication(Long id) {
		return note_publicationRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		note_publicationRepository.delete(note_publicationRepository.findOne(id));
	}

	@Override
	public NotePublication save(NotePublication note_publication) {
		note_publication.setDateAppreciation(new Date());
		return note_publicationRepository.save(note_publication);
	}

}
 