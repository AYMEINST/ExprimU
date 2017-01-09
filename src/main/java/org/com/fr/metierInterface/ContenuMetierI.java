package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Contenu;
public interface ContenuMetierI {
public Page<Contenu> contenuPage(int page, int size);
public List<Contenu> contenuList();
public Contenu getContenu(Long id);
public Contenu save(Contenu contenu);
public void delete(Long id);
}
