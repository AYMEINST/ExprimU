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
import org.exprimu.prog.entity.LigneMessage;
import org.exprimu.prog.entity.Message;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metier.ForumCommentaireMetier;
import org.exprimu.prog.metier.ForumMetier;
import org.exprimu.prog.metier.LigneMessageMetier;
import org.exprimu.prog.metier.MessageMetier;
import org.exprimu.prog.metier.UtilisateurMetier;

@Controller
@RequestMapping(value = "/MessageJson")
public class MessageJsonController {
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	@Autowired
	private MessageMetier messageMetier;
	@Autowired
	private LigneMessageMetier ligneMessageMetier;
	@Autowired
	private AmisMetier amisMetier;

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/GetConnectedUser")
	public Map<String, Object> getConnectedUser() {
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
		return x;
	}

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Map")
	public List<Object> maps(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "rech", defaultValue = "") String rech) {
		long id = ((Utilisateur) getConnectedUser().get("utilisateur")).getIdUtilisateur();
		List<Message> messages = messageMetier.getMessageByUtilisateur(id);
		List<Object> mx = new ArrayList<Object>();
		for (Message m : messages) {
			List<LigneMessage> l = ligneMessageMetier.ligneMessageByIdMessageList(m.getIdMessage());
			Map<String, Object> f = new HashMap<String, Object>();
			f.put("message", m);
			f.put("size", l.size());
			f.put("idUtilisateur", id);
			mx.add(f);
		}
		return mx;
	}

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Show")
	public Map<String, Object> getMap(@RequestParam(name = "id", defaultValue = "0") long id, @RequestParam(name = "auto", defaultValue = "1") int auto) {
		Message message = messageMetier.getMessage(id);
		long idUtilisateur = ((Utilisateur) getConnectedUser().get("utilisateur")).getIdUtilisateur();
		if (message.getUtilisateurE().getIdUtilisateur()==idUtilisateur){
			message.setLuE(true);
		}else{
			message.setLuR(true);
		}
		if (auto == 0){
			message = messageMetier.save(message);
		}
		List<LigneMessage> ligneMessages = ligneMessageMetier.ligneMessageByIdMessageList(id);

		Map<String, Object> mx = new HashMap<String, Object>();
		mx.put("idUtilisateur", idUtilisateur);
		mx.put("message", message);
		mx.put("ligneMessages", ligneMessages);
		

		return mx;
	}

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/New")
	public Map<String, Object> newMap() {
		long id = ((Utilisateur) getConnectedUser().get("utilisateur")).getIdUtilisateur();
		List<Utilisateur> u = amisMetier.getAmisByUtilisateurList(id);
		Map<String, Object> mx = new HashMap<String, Object>();
		mx.put("utilisateur", u);
		return mx;
	}

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Save", method = RequestMethod.GET)
	public String saveMap(@RequestParam(name = "objet", defaultValue = "") String objet,
			@RequestParam(name = "to", defaultValue = "0") long to,
			@RequestParam(name = "description", defaultValue = "") String message) {
		System.out.println("objet : " + objet + " to : " + to + " message : " + message);
		
		Utilisateur ufrom = (Utilisateur)getConnectedUser().get("utilisateur");
		Utilisateur uto = utilisateurMetier.getUtilisateur(to);
		Date date = new Date();
		
		Message m = messageMetier.save(new Message(objet, date, true, false, ufrom, uto)); 
		ligneMessageMetier.save(new LigneMessage(message, date, ufrom, m));
		
		return "null";
	}


	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/SaveMessage", method = RequestMethod.GET)
	public String saveMessageMap(@RequestParam(name = "idMessage", defaultValue = "0") long idMessage,
			@RequestParam(name = "text", defaultValue = "") String message) {
		
		Utilisateur ufrom = (Utilisateur)getConnectedUser().get("utilisateur");
		Message m = messageMetier.getMessage(idMessage);
		Date date = new Date();
		if (m.getUtilisateurE().getIdUtilisateur() == ufrom.getIdUtilisateur()){
			m.setLuR(false);
		}else{
			m.setLuE(false);
		}
		m.setDate(date); 
		ligneMessageMetier.save(new LigneMessage(message, date, ufrom, m));
		messageMetier.save(m);
		return "null";
	}
	
}
