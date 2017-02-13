package org.exprimu.prog.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.exprimu.prog.dao.UtilisateurRepository;
import org.exprimu.prog.entity.Document;
import org.exprimu.prog.entity.Fichier;
import org.exprimu.prog.entity.Publication;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metier.FichierMetier;
import org.exprimu.prog.metier.PublicationMetier;
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
import org.springframework.web.multipart.MultipartFile;

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
	@Autowired
	private FichierMetier fichierMetier;

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
	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/SaveValidatedUser", method = RequestMethod.POST)
	public void savePublication(@RequestParam String nom, @RequestParam String prenom,@RequestParam String password, @RequestParam String profession,@RequestParam String email,
			@RequestParam String adresse,@RequestParam String codePostal, @RequestParam String genre,@RequestParam String pseudonyme, 
			@RequestParam Date dateNaissance,@RequestParam String pays, @RequestParam("files") MultipartFile[] files) {
		System.out.println("nom :" + nom);
		System.out.println("prenom :" + prenom);
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				// file.getBytes();
				System.out.println(file.getName());
				System.out.println(file.getSize());
				System.out.println(file.getContentType());
				try {
					Fichier fichier = new Fichier(file.getName(), file.getContentType(), file.getSize(), file.getBytes());
					Long idFichier= fichierMetier.save(fichier).getIdFichier();
					Utilisateur utilisateur = new Utilisateur(nom,prenom,dateNaissance,adresse,codePostal,idFichier,profession,password,email,genre,pseudonyme,pays);
					utilisateurMetier.save(utilisateur);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}	
	
	

	
	

	
}
