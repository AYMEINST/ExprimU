package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Liste_amis;
public interface Liste_amisMetierI {
public Page<Liste_amis> liste_amisPage(int page, int size);
public List<Liste_amis> liste_amisList();
public Liste_amis getListe_amis(Long id);
public Liste_amis save(Liste_amis liste_amis);
public void delete(Long id);
}
