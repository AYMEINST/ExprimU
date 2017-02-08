package org.exprimu.prog.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.UtilisateurRepository;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metierImp.UtilisateurMetierImp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Service
public class UtilisateurMetier implements UtilisateurMetierImp {
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

	@Override
	public Map<String, Object> getConnectedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User user = (User) auth.getPrincipal();
		String email = user.getUsername(); 
		String password = user.getPassword();
		List<String> l = new ArrayList<String>();
		for (GrantedAuthority x : user.getAuthorities()) {
			l.add(x.getAuthority());
		}
		Map<String, Object> x = new HashMap<String, Object>(4);
		x.put("username", email);
		x.put("password", password);
     	x.put("utilisateur", getUtilisateurByEmail(email));
		x.put("role", l);		
		return x;
	}

	@Override
	public Utilisateur getUtilisateurByEmail(String email) {
		List<Utilisateur> x = utilisateurRepository.getUtilisateurByEmail(email);
		return ((x.isEmpty()) ? null : x.get(0));
	}
	
	


	
	
	
	
}
