package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Utilisateur;
public interface UtilisateurMetierI {
public Page<Utilisateur> utilisateurPage(int page, int size);
public List<Utilisateur> utilisateurList();
public Utilisateur getUtilisateur(Long id);
public Utilisateur save(Utilisateur utilisateur);
public void delete(Long id);
}
