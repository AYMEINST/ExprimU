package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Amis;
public interface Liste_amisMetierI {
public Page<Amis> liste_amisPage(int page, int size);
public List<Amis> liste_amisList();
public Amis getListe_amis(Long id);
public Amis save(Amis liste_amis);
public void delete(Long id);
}
