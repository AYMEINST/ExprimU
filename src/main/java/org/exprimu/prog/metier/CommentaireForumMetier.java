package org.exprimu.prog.metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.CommentaireForumRepository;
import org.exprimu.prog.entity.CommentaireForum;
import org.exprimu.prog.metierImp.CommentaireForumMetierImp;
@Service
public class CommentaireForumMetier implements CommentaireForumMetierImp{
@Autowired
private CommentaireForumRepository commentaireforumRepository;
@Override
public Page<CommentaireForum> commentaireforumPage(int page, int size) {
return commentaireforumRepository.findAll(new PageRequest(page, size));
}
@Override
public List<CommentaireForum> commentaireforumList() {
return commentaireforumRepository.findAll();
}
@Override
public CommentaireForum getCommentaireForum(Long id) {
return commentaireforumRepository.findOne(id);
}
@Override
public CommentaireForum save(CommentaireForum commentaireforum) {
return commentaireforumRepository.save(commentaireforum);
}
@Override
public void delete(Long id) {
commentaireforumRepository.delete(commentaireforumRepository.findOne(id));
}
}
