package org.com.fr.metierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.HistoriqueRepository;
import org.com.fr.entity.Historique;
import org.com.fr.metierInterface.HistoriqueMetierI;
@Service
public class HistoriqueMetier implements HistoriqueMetierI{
@Autowired
private HistoriqueRepository historiqueRepository;
@Override
public Page<Historique> historiquePage(int page, int size) {
return historiqueRepository.findAll(new PageRequest(page, size));
}
@Override
public List<Historique> historiqueList() {
return historiqueRepository.findAll();
}
@Override
public Historique getHistorique(Long id) {
return historiqueRepository.findOne(id);
}
@Override
public Historique save(Historique historique) {
return historiqueRepository.save(historique);
}
@Override
public void delete(Long id) {
historiqueRepository.delete(historiqueRepository.findOne(id));
}
}
