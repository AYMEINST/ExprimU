package org.exprimu.prog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;

import org.exprimu.prog.entity.Forum;
import org.exprimu.prog.entity.ForumCommentaire;
import org.exprimu.prog.entity.Roles;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metier.ForumCommentaireMetier;
import org.exprimu.prog.metier.ForumMetier;
import org.exprimu.prog.metier.RolesMetier;
import org.exprimu.prog.metier.UtilisateurMetier;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@PropertySource("classpath:application.properties")
public class ExprimUApplication {
	public static void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(ExprimUApplication.class, args);
		
		
//		RolesMetier rolesMetier = ctx.getBean(RolesMetier.class);
//		Roles r1 = rolesMetier.save(new Roles(1l, "ADMIN"));
//		Roles r2 = rolesMetier.save(new Roles(2l, "USER"));
//		 
//		
//		UtilisateurMetier utilisateurMetier = ctx.getBean(UtilisateurMetier.class);
//		
//		Utilisateur u = new Utilisateur("aly","momo",new Date(),null,null,0L,null,"123","rachid@gmail.com",true);
//		u.getListRoles().add(r1);
//		r1.getUtilisateur().add(u);
//		u.getListRoles().add(r2);
//		r2.getUtilisateur().add(u);
//		utilisateurMetier.save(u);
//		
//		
//		u = new Utilisateur("aly","momo",new Date(),null,null,0L,null,"123","rachid@gmail.com",true);
//		u.getListRoles().add(r2);
//		r2.getUtilisateur().add(u);
//		utilisateurMetier.save(u);
//		
//		u = new Utilisateur("aly","momo",new Date(),null,null,0L,null,"123","user@gmail.com",true);
//		u.getListRoles().add(r1);
//		r1.getUtilisateur().add(u);
//		utilisateurMetier.save(u);
//		
//		
//		
//		
//		
//		ForumMetier forumMetier = ctx.getBean(ForumMetier.class);
//
//		Forum forum = new Forum(new Date(), "Theme 1", "tittre 1", "description 1");
//		forum.setIdUtilisateur(utilisateurMetier.getUtilisateur(1L));
//		forumMetier.save(forum);
//		forum = new Forum(new Date(), "Theme 2", "tittre 2", "description 2");
//		forum.setIdUtilisateur(utilisateurMetier.getUtilisateur(1L));
//		forum = forumMetier.save(forum);
//
//		ForumCommentaireMetier forumCommentaireMetier = ctx.getBean(ForumCommentaireMetier.class);
//		ForumCommentaire forumCommentaire = new ForumCommentaire("text 1", new Date());
//		forumCommentaire.setIdForum(forumMetier.getForum(1L));
//		forumCommentaire.setIdUtilisateur(utilisateurMetier.getUtilisateur(1L));
//		forumCommentaireMetier.save(forumCommentaire);
//		
		// UPDATE utilisateur SET password = MD5(password)
		
	}

}
