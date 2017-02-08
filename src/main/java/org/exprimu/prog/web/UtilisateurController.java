package org.exprimu.prog.web;

import java.util.List;

import org.exprimu.prog.dao.UtilisateurRepository;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metier.UtilisateurMetier;
import org.exprimu.prog.metier.UtilisateurTempMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/utilisateur")
public class UtilisateurController {
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private UtilisateurTempMetier utilisateurTempMetier;
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	public Page<Utilisateur> utilisateurPage(int page, int size) {
		return utilisateurMetier.utilisateurPage(page, size);
	}

	public Utilisateur getUtilisateur(Long id) {
		return utilisateurMetier.getUtilisateur(id);
	}
	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value="/saveusertemp/{id}",method=RequestMethod.POST)
	public String saveu(@RequestBody Long id) {
		System.out.println("hi hh+++");
		utilisateurTempMetier.accepteru(id);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("boulaajoul.rachid@gmail.com");
        mailMessage.setReplyTo("boulaajoul.rachid@gmail.com");
        mailMessage.setFrom("boulaajoul.rachid@gmail.com");
        mailMessage.setSubject("Inscription");
        mailMessage.setText("Votre compte est bien activer ");
        javaMailSender.send(mailMessage);
		return "redirect:/Index/listUserTmp";
	}
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value="/desactiverut/{id}",method=RequestMethod.POST)
	public String desactiverUt(@RequestBody Long id) {
		utilisateurTempMetier.desactiviercpt(id);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("boulaajoul.rachid@gmail.com");
        mailMessage.setReplyTo("boulaajoul.rachid@gmail.com");
        mailMessage.setFrom("boulaajoul.rachid@gmail.com");
        mailMessage.setSubject("Inscription");
        mailMessage.setText("Votre compte est désactiver , pour l'activer veuillez contacter l'admin");
        javaMailSender.send(mailMessage);
		return "redirect:/Index/listUserTmp";
	}
	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value="/listuser",method=RequestMethod.GET)
	public Page<Utilisateur> listuser(@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="")int page,
			@RequestParam(name="size",defaultValue="")int size
			){
		return utilisateurRepository.listuserByMc("%"+mc+"%", new PageRequest(page, size));
	}
	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value="/UserConnect",method=RequestMethod.GET)
	public Utilisateur userConnect(){
		System.out.println("ici ");
		return (Utilisateur) utilisateurMetier.getConnectedUser().get("utilisateur");
	}
	

	
}
