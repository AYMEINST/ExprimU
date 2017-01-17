package org.exprimu.prog.metierImp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.exprimu.prog.entity.NotePublication;
public interface NotePublicationMetierImp {
public Page<NotePublication> notepublicationPage(int page, int size);
public List<NotePublication> notepublicationList();
public NotePublication getNotePublication(Long id);
public NotePublication save(NotePublication notepublication);
public void delete(Long id);
}
