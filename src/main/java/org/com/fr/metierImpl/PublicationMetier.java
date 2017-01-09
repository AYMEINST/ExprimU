package org.com.fr.metierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.PublicationRepository;
import org.com.fr.entity.Publication;
import org.com.fr.metierInterface.PublicationMetierI;
@Service
public class PublicationMetier implements PublicationMetierI{
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
public Publication save(Publication publication) {
return publicationRepository.save(publication);
}
@Override
public void delete(Long id) {
publicationRepository.delete(publicationRepository.findOne(id));
}
}
