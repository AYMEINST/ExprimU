package org.exprimu.prog.metierImp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.exprimu.prog.entity.Document;
import org.exprimu.prog.entity.Publication;
public interface PublicationMetierImp {
public Page<Publication> publicationPage(int page, int size);
public List<Publication> publicationList();
public Publication getPublication(Long id);
public Publication save(Publication publication );
public void delete(Long id);
public void updatePublication (Long idPublication ,String statue,String tritrePublication, String DescriptifDocument ,Long idFichier );
}
