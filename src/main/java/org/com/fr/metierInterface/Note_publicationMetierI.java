package org.com.fr.metierInterface;

import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Note_publication;

public interface Note_publicationMetierI {
	public Page<Note_publication> note_publicationPage(int page, int size);

	public List<Note_publication> note_publicationList();

	public Note_publication getNote_Publication(Long id);

	public Note_publication save(Note_publication note_publication);

	public void delete(Long id);
}
