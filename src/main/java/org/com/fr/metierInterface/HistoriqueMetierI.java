package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Historique;
public interface HistoriqueMetierI {
public Page<Historique> historiquePage(int page, int size);
public List<Historique> historiqueList();
public Historique getHistorique(Long id);
public Historique save(Historique historique);
public void delete(Long id);
}
