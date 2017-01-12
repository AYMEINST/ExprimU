package org.com.fr.metierImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.ForumRepository;
import org.com.fr.entity.Forum;
import org.com.fr.metierInterface.ForumMetierI;

@Service
public class ForumMetier implements ForumMetierI {
	@Autowired
	private ForumRepository forumRepository;

	@Override
	public Page<Forum> forumPage(int page, int size) {
		return forumRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public List<Forum> forumList() {
		return forumRepository.findAll();
	}

	@Override
	public Forum getForum(Long id) {
		return forumRepository.findOne(id);
	}

	@Override
	public Forum save(Forum forum) {
		return forumRepository.save(forum);
	}

	@Override
	public void delete(Long id) {
		forumRepository.delete(forumRepository.findOne(id));
	}
}
