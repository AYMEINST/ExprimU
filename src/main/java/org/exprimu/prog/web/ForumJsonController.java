package org.exprimu.prog.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import org.exprimu.prog.entity.Forum;
import org.exprimu.prog.entity.ForumCommentaire;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metier.ForumCommentaireMetier;
import org.exprimu.prog.metier.ForumMetier;
import org.exprimu.prog.metier.UtilisateurMetier;

@Controller
@RequestMapping(value = "/ForumJson")
public class ForumJsonController {
	@Autowired
	private ForumMetier forumMetier;

	@Autowired
	private ForumCommentaireMetier forumCommentaireMetier;

	@Autowired
	private UtilisateurMetier utilisateurMetier;

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
	@RequestMapping(value = "/List")
	public Page<Forum> index(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "rech", defaultValue = "") String rech) {
		Page<Forum> forums = forumMetier.forumPage(page, 10);
		return forums;
	}

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Map")
	public Map<String, Object> Maps(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "rech", defaultValue = "") String rech, @RequestParam(name = "isMy", defaultValue = "0") int isMy) {
		long id = ((Utilisateur) getConnectedUser().get("utilisateur")).getIdUtilisateur();
		Page<Forum> forums = null;
		if (isMy ==0){
			forums = forumMetier.forumPage(page, 10);
		}else{
			forums = forumMetier.myForumPage(id, page, 10);
		}
		List<Object> mx = new ArrayList<Object>();
		for (Forum f : forums.getContent()) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("utilisateur", f.getIdUtilisateur());
			m.put("nbcommantaire", f.getForumCommentaires().size());
			m.put("data", f);
			m.put("owner", (id == f.getIdUtilisateur().getIdUtilisateur()));
			mx.add(m);
		}
		Map<String, Object> x = new HashMap<String, Object>(3);
		x.put("data", mx);
		x.put("totalPages", forums.getTotalPages());
		x.put("last", forums.isLast());
		x.put("totalElements", forums.getTotalElements());
		x.put("size", forums.getSize());
		x.put("number", forums.getNumber());
		x.put("sort", forums.getSort());
		x.put("first", forums.isFirst());
		x.put("numberOfElements", forums.getNumberOfElements());
		return x;
	}

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Show")
	public Map<String, Object> GetMap(@RequestParam(name = "id", defaultValue = "0") long id) {
		Forum forum = forumMetier.getForum(id);
		Utilisateur utilisateur = forum.getIdUtilisateur();
		Map<String, Object> x = new HashMap<String, Object>(3);
		x.put("forum", forum);
		x.put("user", utilisateur);
		x.put("nbcommantaire", forum.getForumCommentaires().size());
		x.put("commentaire", forum.getForumCommentaires());
		return x;
	}

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Get")
	public Forum edit(@RequestParam(name = "id", defaultValue = "0") long id) {
		Forum forum = null;
		if (id == 0) {
			forum = new Forum();
		} else {
			forum = forumMetier.getForum(id);

		}
		return forum;
	}

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/SaveCommentaire", method = RequestMethod.GET)
	public ForumCommentaire saveCommentaire(@RequestParam(name = "idForum", defaultValue = "0") long id,
			@RequestParam(name = "text", defaultValue = "") String text) {
		ForumCommentaire forumCommentaire = new ForumCommentaire(text, new Date());
		forumCommentaire.setIdUtilisateur((Utilisateur) getConnectedUser().get("utilisateur"));
		forumCommentaire.setIdForum(forumMetier.getForum(id));
		return forumCommentaireMetier.save(forumCommentaire);
	}

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Save", method = RequestMethod.POST)
	public Forum save(@RequestBody Forum forum) {
		if (forum.getIdForum() == 0) {
			forum.setIdUtilisateur((Utilisateur) getConnectedUser().get("utilisateur"));
			forum.setDateCreation(new Date());
		}
		return forumMetier.save(forum);
	}

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Delete")
	public Forum delete(@RequestParam(name = "id", defaultValue = "0") long id) {
		forumMetier.delete(id);
		return null;
	}
}
