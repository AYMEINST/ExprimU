package org.com.fr.metierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.ContenuRepository;
import org.com.fr.entity.Contenu;
import org.com.fr.metierInterface.ContenuMetierI;
@Service
public class ContenuMetier implements ContenuMetierI{
@Autowired
private ContenuRepository contenuRepository;
@Override
public Page<Contenu> contenuPage(int page, int size) {
return contenuRepository.findAll(new PageRequest(page, size));
}
@Override
public List<Contenu> contenuList() {
return contenuRepository.findAll();
}
@Override
public Contenu getContenu(Long id) {
return contenuRepository.findOne(id);
}
@Override
public Contenu save(Contenu contenu) {
return contenuRepository.save(contenu);
}
@Override
public void delete(Long id) {
contenuRepository.delete(contenuRepository.findOne(id));
}
}
