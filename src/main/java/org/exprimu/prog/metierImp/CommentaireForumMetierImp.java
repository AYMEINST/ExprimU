package org.exprimu.prog.metierImp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.exprimu.prog.entity.CommentaireForum;
public interface CommentaireForumMetierImp {
public Page<CommentaireForum> commentaireforumPage(int page, int size);
public List<CommentaireForum> commentaireforumList();
public CommentaireForum getCommentaireForum(Long id);
public CommentaireForum save(CommentaireForum commentaireforum);
public void delete(Long id);
}
