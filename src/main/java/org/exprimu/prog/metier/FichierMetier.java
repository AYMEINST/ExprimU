package org.exprimu.prog.metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.FichierRepository;
import org.exprimu.prog.entity.Fichier;
import org.exprimu.prog.metierImp.FichierMetierImp;
@Service
public class FichierMetier implements FichierMetierImp{
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
