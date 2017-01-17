package org.exprimu.prog.metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.UtilisateurRepository;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metierImp.UtilisateurMetierImp;
@Service
public class UtilisateurMetier implements UtilisateurMetierImp{
@Autowired
private UtilisateurRepository utilisateurRepository;
@Override
public Page<Utilisateur> utilisateurPage(int page, int size) {
return utilisateurRepository.findAll(new PageRequest(page, size));
}
@Override
public List<Utilisateur> utilisateurList() {
return utilisateurRepository.findAll();
}
@Override
public Utilisateur getUtilisateur(Long id) {
return utilisateurRepository.findOne(id);
}
@Override
public Utilisateur save(Utilisateur utilisateur) {
return utilisateurRepository.save(utilisateur);
}
@Override
public void delete(Long id) {
utilisateurRepository.delete(utilisateurRepository.findOne(id));
}
}
