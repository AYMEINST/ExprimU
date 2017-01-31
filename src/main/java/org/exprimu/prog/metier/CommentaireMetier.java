package org.exprimu.prog.metier;

import java.util.List;

import org.exprimu.prog.dao.CommentaireRepository;
import org.exprimu.prog.entity.Commentaire;
import org.exprimu.prog.metierImp.CommentaireMetierImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CommentaireMetier implements CommentaireMetierImp {
	@Autowired
	private CommentaireRepository commentaireRepository;

	@Override
	public List<Commentaire> commentaireList() {
		// TODO Auto-generated method stub
		return commentaireRepository.findAll();
	}

	@Override
	public Commentaire getCommentaire(Long id) {
		// TODO Auto-generated method stub
		return commentaireRepository.getOne(id);
	}

	@Override
	public Commentaire save(Commentaire commentaire) {
		// TODO Auto-generated method stub
		return commentaireRepository.save(commentaire);
	}

	@Override
	public void delete(Long id) {
		commentaireRepository.delete(id);
		
	}

	@Override
	public Page<Commentaire> commentairePage(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}
		

}
