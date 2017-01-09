package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Fichier;
public interface FichierMetierI {
public Page<Fichier> fichierPage(int page, int size);
public List<Fichier> fichierList();
public Fichier getFichier(Long id);
public Fichier save(Fichier fichier);
public void delete(Long id);
}
