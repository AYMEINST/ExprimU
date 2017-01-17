package org.com.fr.metierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.Carte_BKRepository;
import org.com.fr.entity.CarteBK;
import org.com.fr.metierInterface.Carte_BKMetierI;
@Service
public class Carte_BKMetier implements Carte_BKMetierI{
@Autowired
private Carte_BKRepository carte_bkRepository;
@Override
public Page<CarteBK> carte_bkPage(int page, int size) {
return carte_bkRepository.findAll(new PageRequest(page, size));
}
@Override
public List<CarteBK> carte_bkList() {
return carte_bkRepository.findAll();
}
@Override
public CarteBK getCarte_BK(Long id) {
return carte_bkRepository.findOne(id);
}
@Override
public CarteBK save(CarteBK carte_bk) {
return carte_bkRepository.save(carte_bk);
}
@Override
public void delete(Long id) {
carte_bkRepository.delete(carte_bkRepository.findOne(id));
}
}
