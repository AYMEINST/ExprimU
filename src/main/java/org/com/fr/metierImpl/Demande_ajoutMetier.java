package org.com.fr.metierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.Demande_ajoutRepository;
import org.com.fr.entity.Demande_ajout;
import org.com.fr.metierInterface.Demande_ajoutMetierI;
@Service
public class Demande_ajoutMetier implements Demande_ajoutMetierI{
@Autowired
private Demande_ajoutRepository demande_ajoutRepository;
@Override
public Page<Demande_ajout> demande_ajoutPage(int page, int size) {
return demande_ajoutRepository.findAll(new PageRequest(page, size));
}
@Override
public List<Demande_ajout> demande_ajoutList() {
return demande_ajoutRepository.findAll();
}
@Override
public Demande_ajout getDemande_ajout(Long id) {
return demande_ajoutRepository.findOne(id);
}
@Override
public Demande_ajout save(Demande_ajout demande_ajout) {
return demande_ajoutRepository.save(demande_ajout);
}
@Override
public void delete(Long id) {
demande_ajoutRepository.delete(demande_ajoutRepository.findOne(id));
}
}
