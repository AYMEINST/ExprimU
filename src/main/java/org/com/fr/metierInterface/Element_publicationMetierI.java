package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Element_publication;
public interface Element_publicationMetierI {
public Page<Element_publication> element_publicationPage(int page, int size);
public List<Element_publication> element_publicationList();
public Element_publication getElement_publication(Long id);
public Element_publication save(Element_publication element_publication);
public void delete(Long id);
}
