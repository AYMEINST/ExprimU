package org.exprimu.prog.web;

import javax.mail.MessagingException;
import javax.websocket.server.PathParam;

import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metier.UtilisateurMetier;
import org.exprimu.prog.metier.UtilisateurTempMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/utilisateur")
public class UtilisateurController {
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	
	private UtilisateurTempMetier utilisateurTempMetier;

	public Page<Utilisateur> utilisateurPage(int page, int size) {
		return utilisateurMetier.utilisateurPage(page, size);
	}

	public Utilisateur getUtilisateur(Long id) {
		return utilisateurMetier.getUtilisateur(id);
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/saveutilisateur",method=RequestMethod.GET)
	public String save(@PathParam(value="id") Long id) throws MessagingException {
		utilisateurTempMetier.accepteru(id);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("boulaajoul.rachid@gmail.com");
        mailMessage.setReplyTo("boulaajoul.rachid@gmail.com");
        mailMessage.setFrom("boulaajoul.rachid@gmail.com");
        mailMessage.setSubject("Inscription");
        mailMessage.setText("Votre compte est bien activer ");
        javaMailSender.send(mailMessage);
		return "redirect:/utilisateurt/flistutilisateurt";
	}
	
	@RequestMapping(value="/desactiverut",method=RequestMethod.GET)
	public String desactiverUt(@PathParam(value="id") Long id) {
		utilisateurTempMetier.desactiviercpt(id);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("boulaajoul.rachid@gmail.com");
        mailMessage.setReplyTo("boulaajoul.rachid@gmail.com");
        mailMessage.setFrom("boulaajoul.rachid@gmail.com");
        mailMessage.setSubject("Inscription");
        mailMessage.setText("Votre compte est désactiver , pour l'activer veuillez contacter l'admin");
        javaMailSender.send(mailMessage);
		return "redirect:/utilisateurt/flistutilisateurt";
	}
	
	
}
