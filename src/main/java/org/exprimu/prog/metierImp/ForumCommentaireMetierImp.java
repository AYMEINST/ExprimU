package org.exprimu.prog.metierImp;

import java.util.List;

import org.exprimu.prog.entity.ForumCommentaire;
import org.springframework.data.domain.Page;

public interface ForumCommentaireMetierImp {
	public Page<ForumCommentaire> forumcommentairePage(int page, int size);

	public List<ForumCommentaire> forumcommentaireList();

	public ForumCommentaire getForumCommentaire(Long id);

	public ForumCommentaire save(ForumCommentaire forumcommentaire);

	public void delete(Long id);
}
