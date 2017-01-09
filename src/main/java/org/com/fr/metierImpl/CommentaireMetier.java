package org.com.fr.metierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.CommentaireRepository;
import org.com.fr.entity.Commentaire;
import org.com.fr.metierInterface.CommentaireMetierI;
@Service
public class CommentaireMetier implements CommentaireMetierI{
@Autowired
private CommentaireRepository commentaireRepository;
@Override
public Page<Commentaire> commentairePage(int page, int size) {
return commentaireRepository.findAll(new PageRequest(page, size));
}
@Override
public List<Commentaire> commentaireList() {
return commentaireRepository.findAll();
}
@Override
public Commentaire getCommentaire(Long id) {
return commentaireRepository.findOne(id);
}
@Override
public Commentaire save(Commentaire commentaire) {
return commentaireRepository.save(commentaire);
}
@Override
public void delete(Long id) {
commentaireRepository.delete(commentaireRepository.findOne(id));
}
}
