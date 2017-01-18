package org.exprimu.prog.metier;

import org.exprimu.prog.dao.ForumCommentaireRepository;
import org.exprimu.prog.entity.ForumCommentaire;
import org.exprimu.prog.metierImp.ForumCommentaireMetierImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ForumCommentaireMetier implements ForumCommentaireMetierImp {
	@Autowired
	private ForumCommentaireRepository forumcommentaireRepository;

	@Override 
	public Page<ForumCommentaire> forumcommentairePage(int page, int size) {
		return forumcommentaireRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public List<ForumCommentaire> forumcommentaireList() {
		return forumcommentaireRepository.findAll();
	}

	@Override
	public ForumCommentaire getForumCommentaire(Long id) {
		return forumcommentaireRepository.findOne(id);
	}

	@Override
	public ForumCommentaire save(ForumCommentaire forumcommentaire) {
		return forumcommentaireRepository.save(forumcommentaire);
	}

	@Override
	public void delete(Long id) {
		forumcommentaireRepository.delete(forumcommentaireRepository.findOne(id));
	}
}
