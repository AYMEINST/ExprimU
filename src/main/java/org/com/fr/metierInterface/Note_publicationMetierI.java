package org.com.fr.metierInterface;

import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.NotePublication;

public interface Note_publicationMetierI {
	public Page<NotePublication> note_publicationPage(int page, int size);

	public List<NotePublication> note_publicationList();

	public NotePublication getNote_Publication(Long id);

	public NotePublication save(NotePublication note_publication);

	public void delete(Long id);
}
