package org.exprimu.prog.metierImp;

import java.util.List;
import org.springframework.data.domain.Page;
import org.exprimu.prog.entity.Forum;

public interface ForumMetierImp {
	public Page<Forum> forumPage(int page, int size);

	public Page<Forum> myForumPage(long id, int page, int size);

	public List<Forum> forumList();

	public Forum getForum(Long id);

	public Forum save(Forum forum);

	public void delete(Long id);
}
