package org.exprimu.prog.metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.NotePublicationRepository;
import org.exprimu.prog.entity.NotePublication;
import org.exprimu.prog.metierImp.NotePublicationMetierImp;
@Service
public class NotePublicationMetier implements NotePublicationMetierImp{
@Autowired
private NotePublicationRepository notepublicationRepository;
@Override
public Page<NotePublication> notepublicationPage(int page, int size) {
return notepublicationRepository.findAll(new PageRequest(page, size));
}
@Override
public List<NotePublication> notepublicationList() {
return notepublicationRepository.findAll();
}
@Override
public NotePublication getNotePublication(Long id) {
return notepublicationRepository.findOne(id);
}
@Override
public NotePublication save(NotePublication notepublication) {
return notepublicationRepository.save(notepublication);
}
@Override
public void delete(Long id) {
notepublicationRepository.delete(notepublicationRepository.findOne(id));
}
}
