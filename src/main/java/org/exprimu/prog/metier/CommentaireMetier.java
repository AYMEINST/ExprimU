package org.exprimu.prog.metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.CommentaireRepository;
import org.exprimu.prog.entity.Commentaire;
import org.exprimu.prog.metierImp.CommentaireMetierImp;
@Service
public class CommentaireMetier implements CommentaireMetierImp{
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
