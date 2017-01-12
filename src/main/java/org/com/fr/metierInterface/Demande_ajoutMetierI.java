package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Demande_ajout;
public interface Demande_ajoutMetierI {
public Page<Demande_ajout> demande_ajoutPage(int page, int size);
public List<Demande_ajout> demande_ajoutList();
public Demande_ajout getDemande_ajout(Long id);
public Demande_ajout save(Demande_ajout demande_ajout);
public void delete(Long id);
}
