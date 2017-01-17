package org.exprimu.prog.metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.UtilisateurTempRepository;
import org.exprimu.prog.entity.UtilisateurTemp;
import org.exprimu.prog.metierImp.UtilisateurTempMetierImp;
@Service
public class UtilisateurTempMetier implements UtilisateurTempMetierImp{
@Autowired
private UtilisateurTempRepository utilisateurtempRepository;
@Override
public Page<UtilisateurTemp> utilisateurtempPage(int page, int size) {
return utilisateurtempRepository.findAll(new PageRequest(page, size));
}
@Override
public List<UtilisateurTemp> utilisateurtempList() {
return utilisateurtempRepository.findAll();
}
@Override
public UtilisateurTemp getUtilisateurTemp(Long id) {
return utilisateurtempRepository.findOne(id);
}
@Override
public UtilisateurTemp save(UtilisateurTemp utilisateurtemp) {
return utilisateurtempRepository.save(utilisateurtemp);
}
@Override
public void delete(Long id) {
utilisateurtempRepository.delete(utilisateurtempRepository.findOne(id));
}
}
