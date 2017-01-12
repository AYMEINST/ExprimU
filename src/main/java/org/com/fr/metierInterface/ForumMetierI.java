package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Forum;
public interface ForumMetierI {
public Page<Forum> forumPage(int page, int size);
public List<Forum> forumList();
public Forum getForum(Long id);
public Forum save(Forum forum);
public void delete(Long id);
}
