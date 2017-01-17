package org.exprimu.prog.metierImp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.exprimu.prog.entity.Utilisateur;
public interface UtilisateurMetierImp {
public Page<Utilisateur> utilisateurPage(int page, int size);
public List<Utilisateur> utilisateurList();
public Utilisateur getUtilisateur(Long id);
public Utilisateur save(Utilisateur utilisateur);
public void delete(Long id);
}
