package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Publier;
public interface PublierMetierI {
public Page<Publier> publierPage(int page, int size);
public List<Publier> publierList();
public Publier getPublier(Long id);
public Publier save(Publier publier);
public void delete(Long id);
}
