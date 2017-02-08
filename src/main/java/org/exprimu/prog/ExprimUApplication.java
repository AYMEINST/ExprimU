package org.exprimu.prog;

import java.util.Date;

import org.exprimu.prog.entity.Amis;
import org.exprimu.prog.entity.Document;
import org.exprimu.prog.entity.Forum;
import org.exprimu.prog.entity.ForumCommentaire;
import org.exprimu.prog.entity.LigneMessage;
import org.exprimu.prog.entity.Message;
import org.exprimu.prog.entity.Publication;
import org.exprimu.prog.entity.Roles;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metier.AmisMetier;
import org.exprimu.prog.metier.DocumentMetier;
import org.exprimu.prog.metier.ForumCommentaireMetier;
import org.exprimu.prog.metier.ForumMetier;
import org.exprimu.prog.metier.LigneMessageMetier;
import org.exprimu.prog.metier.MessageMetier;
import org.exprimu.prog.metier.PublicationMetier;
import org.exprimu.prog.metier.RolesMetier;
import org.exprimu.prog.metier.UtilisateurMetier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
// @PropertySource("classpath:application.properties")
public class ExprimUApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ExprimUApplication.class, args);

		RolesMetier rolesMetier = ctx.getBean(RolesMetier.class);
		Roles r1 = rolesMetier.save(new Roles(1l, "ADMIN"));
		Roles r2 = rolesMetier.save(new Roles(2l, "USER"));

		UtilisateurMetier utilisateurMetier = ctx.getBean(UtilisateurMetier.class);

		Utilisateur u = new Utilisateur("aly", "momo", new Date(), null, null, 0L, null, "123", "aly@gmail.com", true);
		u.getListRoles().add(r1);
		u.setPseudonyme("maan354");
		r1.getUtilisateur().add(u);
		u.getListRoles().add(r2);
		r2.getUtilisateur().add(u);
		Utilisateur u1 = utilisateurMetier.save(u);

		u = new Utilisateur("admin", "the  boss", new Date(), null, null, 0L, null, "123", "admin@gmail.com", true);
		u.getListRoles().add(r2);
		r2.getUtilisateur().add(u);
		u.setPseudonyme("admin");
		Utilisateur u2 = utilisateurMetier.save(u);

		u = new Utilisateur("ndiaye", "Mohamed aly  anda  ", new Date(), null, null, 0L, null, "123", "user@gmail.com", true);
		u.getListRoles().add(r1);
		r1.getUtilisateur().add(u);
		u.setPseudonyme("Moha");
		Utilisateur u3 = utilisateurMetier.save(u);

		// UPDATE utilisateur SET password = MD5(password)

		PublicationMetier PM = ctx.getBean(PublicationMetier.class);
		
		DocumentMetier DM = ctx.getBean(DocumentMetier.class);
		

		Publication P =new  Publication();
		P.setTitrePublication("Mon  premier");
		P.setStatuePublication("mon  statue");
		P.setDatePublication(new Date());
		P.setUtilisateur(u);
		PM.save(P);
		
		Document D =new Document();
	    D.setDateCreation(new Date());
	    D.setDescriptionFichier("Photot");
	    D.setIdFichier(2l);
	    D.setPublication(P);
	    DM.save(D);
		
	    AmisMetier amisMetier = ctx.getBean(AmisMetier.class);
		amisMetier.save(new Amis(u1, u2, new Date()));
		amisMetier.save(new Amis(u2, u1, new Date()));

		amisMetier.save(new Amis(u1, u3, new Date()));
		amisMetier.save(new Amis(u3, u1, new Date()));

		amisMetier.save(new Amis(u2, u3, new Date()));
		amisMetier.save(new Amis(u3, u2, new Date()));

		MessageMetier messageMetier = ctx.getBean(MessageMetier.class);
		Message m1 = messageMetier.save(new Message("Test1", new Date(), true, false, u1, u2));
		Message m2 = messageMetier.save(new Message("Test2", new Date(), true, false, u2, u3));

		LigneMessageMetier ligneMessageMetier = ctx.getBean(LigneMessageMetier.class);

		ligneMessageMetier.save(new LigneMessage("balbalabal 1", new Date(), u1, m1));
		ligneMessageMetier.save(new LigneMessage("balbalabal 2", new Date(), u2, m1));
		ligneMessageMetier.save(new LigneMessage("balbalabal 3", new Date(), u1, m1));

		ligneMessageMetier.save(new LigneMessage("balbalabal 3", new Date(), u2, m2));
		ligneMessageMetier.save(new LigneMessage("balbalabal 2", new Date(), u3, m2));
		ligneMessageMetier.save(new LigneMessage("balbalabal 2", new Date(), u2, m2));

		ForumMetier forumMetier = ctx.getBean(ForumMetier.class);
		ForumCommentaireMetier forumCommentaireMetier = ctx.getBean(ForumCommentaireMetier.class);

		Forum forum = new Forum(new Date(), "Theme 1", "tittre 1", "description 1");
		forum.setIdUtilisateur(utilisateurMetier.getUtilisateur(1L));
		forumMetier.save(forum);

		for (int i = 0; i < 40; i++) {
			Forum f = new Forum(new Date(), "Theme " + i, "tittre " + i, "description " + i);
			long z = (i % 3) + 1;
			f.setIdUtilisateur(utilisateurMetier.getUtilisateur(z));
			f = forumMetier.save(f);
			for (int j = 0; j < 10; j++) {
				ForumCommentaire forumCommentaire = new ForumCommentaire("text " + j, new Date());
				forumCommentaire.setIdForum(f);
				long k = (i % 3) + 1;
				forumCommentaire.setIdUtilisateur(utilisateurMetier.getUtilisateur(k));
				forumCommentaireMetier.save(forumCommentaire);
			}

		}

		// UPDATE utilisateur SET password = MD5(password)


	}
}
