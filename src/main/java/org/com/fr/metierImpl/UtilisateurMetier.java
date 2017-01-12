package org.com.fr.metierImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.UtilisateurRepository;
import org.com.fr.entity.Utilisateur;
import org.com.fr.metierInterface.UtilisateurMetierI;

@Service
public class UtilisateurMetier implements UtilisateurMetierI {
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public Page<Utilisateur> utilisateurPage(int page, int size) {
		return utilisateurRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public List<Utilisateur> utilisateurList() {
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur getUtilisateur(Long id) {
		return utilisateurRepository.findOne(id);
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public void delete(Long id) {
		utilisateurRepository.delete(utilisateurRepository.findOne(id));
	}
}
