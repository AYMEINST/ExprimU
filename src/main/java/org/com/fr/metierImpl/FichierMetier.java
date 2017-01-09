package org.com.fr.metierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.FichierRepository;
import org.com.fr.entity.Fichier;
import org.com.fr.metierInterface.FichierMetierI;
@Service
public class FichierMetier implements FichierMetierI{
@Autowired
private FichierRepository fichierRepository;
@Override
public Page<Fichier> fichierPage(int page, int size) {
return fichierRepository.findAll(new PageRequest(page, size));
}
@Override
public List<Fichier> fichierList() {
return fichierRepository.findAll();
}
@Override
public Fichier getFichier(Long id) {
return fichierRepository.findOne(id);
}
@Override
public Fichier save(Fichier fichier) {
return fichierRepository.save(fichier);
}
@Override
public void delete(Long id) {
fichierRepository.delete(fichierRepository.findOne(id));
}
}
