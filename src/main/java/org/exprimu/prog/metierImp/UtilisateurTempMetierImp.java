package org.exprimu.prog.metierImp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.exprimu.prog.entity.UtilisateurTemp;
public interface UtilisateurTempMetierImp {
public Page<UtilisateurTemp> utilisateurtempPage(int page, int size);
public List<UtilisateurTemp> utilisateurtempList();
public UtilisateurTemp getUtilisateurTemp(Long id);
public UtilisateurTemp save(UtilisateurTemp utilisateurtemp);
public void delete(Long id);
}
