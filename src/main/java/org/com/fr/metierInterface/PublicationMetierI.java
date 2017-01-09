package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Publication;
public interface PublicationMetierI {
public Page<Publication> publicationPage(int page, int size);
public List<Publication> publicationList();
public Publication getPublication(Long id);
public Publication save(Publication publication);
public void delete(Long id);
}
