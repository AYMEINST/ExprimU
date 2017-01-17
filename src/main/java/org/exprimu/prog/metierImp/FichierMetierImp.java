package org.exprimu.prog.metierImp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.exprimu.prog.entity.Fichier;
public interface FichierMetierImp {
public Page<Fichier> fichierPage(int page, int size);
public List<Fichier> fichierList();
public Fichier getFichier(Long id);
public Fichier save(Fichier fichier);
public void delete(Long id);
}
