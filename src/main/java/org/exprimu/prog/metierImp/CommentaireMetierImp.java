package org.exprimu.prog.metierImp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.exprimu.prog.entity.Commentaire;
public interface CommentaireMetierImp {
public Page<Commentaire> commentairePage(int page, int size);
public List<Commentaire> commentaireList();
public Commentaire getCommentaire(Long id);
public Commentaire save(Commentaire commentaire);
public void delete(Long id);
}
