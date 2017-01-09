package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Commentaire;
public interface CommentaireMetierI {
public Page<Commentaire> commentairePage(int page, int size);
public List<Commentaire> commentaireList();
public Commentaire getCommentaire(Long id);
public Commentaire save(Commentaire commentaire);
public void delete(Long id);
}
