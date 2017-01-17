package org.com.fr.metierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.Liste_amisRepository;
import org.com.fr.entity.Amis;
import org.com.fr.metierInterface.Liste_amisMetierI;
@Service
public class Liste_amisMetier implements Liste_amisMetierI{
@Autowired
private Liste_amisRepository liste_amisRepository;
@Override
public Page<Amis> liste_amisPage(int page, int size) {
return liste_amisRepository.findAll(new PageRequest(page, size));
}
@Override
public List<Amis> liste_amisList() {
return liste_amisRepository.findAll();
}
@Override
public Amis getListe_amis(Long id) {
return liste_amisRepository.findOne(id);
}
@Override
public Amis save(Amis liste_amis) {
return liste_amisRepository.save(liste_amis);
}
@Override
public void delete(Long id) {
liste_amisRepository.delete(liste_amisRepository.findOne(id));
}
}
