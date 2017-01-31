package org.exprimu.prog.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exprimu.prog.metier.AmisMetier;
import org.exprimu.prog.metier.FichierMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.exprimu.prog.entity.Amis;
import org.exprimu.prog.entity.Forum;
import org.exprimu.prog.entity.ForumCommentaire;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metier.ForumCommentaireMetier;
import org.exprimu.prog.metier.ForumMetier;
import org.exprimu.prog.metier.UtilisateurMetier;

@Controller
@RequestMapping(value = "/AmisJson")
public class AmisJsonController {
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	@Autowired
	private AmisMetier amisMetier;

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/GetConnectedUser")
	public Map<String, Object> getConnectedUser() {
		// public Utilisateur getConnectedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		User user = (User) auth.getPrincipal();
		String username = user.getUsername(); // get logged in username
		String password = user.getPassword();
		List<String> l = new ArrayList<String>();
		for (GrantedAuthority x : user.getAuthorities()) {
			l.add(x.getAuthority());
		}

		Map<String, Object> x = new HashMap<String, Object>(4);
		x.put("username", username);
		x.put("password", password);
		x.put("utilisateur", utilisateurMetier.getUtilisateurByEmail(username));
		x.put("role", l);
		// return utilisateurMetier.getUtilisateurByLogin(username);
		return x;
	}

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Map")
	public List<Object> Maps(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "rech", defaultValue = "") String rech) {
		long id = ((Utilisateur) getConnectedUser().get("utilisateur")).getIdUtilisateur();
		List<Amis> amis = amisMetier.getAmisByUtilisateur(id);
		List<Object> mx = new ArrayList<Object>();
		for (Amis f : amis) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("idUtilisateurA", f.getUtilisateurA().getIdUtilisateur());
			m.put("utilisateurA", f.getUtilisateurA().getEmail());
			m.put("idUtilisateurP", f.getUtilisateurP().getIdUtilisateur());
			m.put("utilisateurP", f.getUtilisateurP().getEmail());
			mx.add(m);
		}
		return mx;
	}
}
