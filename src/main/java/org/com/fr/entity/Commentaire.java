package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_commentaire;
	private String  contenu;
	private Date date_coms;
	@ManyToOne()
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateurcoms;
//	publication
	@ManyToOne()
	@JoinColumn(name="idpublication")
	private Publication publicationcoms;
	public Long getId_commentaire() {
		return id_commentaire;
	}
	public void setId_commentaire(Long id_commentaire) {
		this.id_commentaire = id_commentaire;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDate_coms() {
		return date_coms;
	}
	public void setDate_coms(Date date_coms) {
		this.date_coms = date_coms;
	}
	public Utilisateur getUtilisateurcoms() {
		return utilisateurcoms;
	}
	public void setUtilisateurcoms(Utilisateur utilisateurcoms) {
		this.utilisateurcoms = utilisateurcoms;
	}
	public Publication getPublicationcoms() {
		return publicationcoms;
	}
	public void setPublicationcoms(Publication publicationcoms) {
		this.publicationcoms = publicationcoms;
	}
	public Commentaire() {
		super();
	}
	public Commentaire(String contenu, Date date_coms, Utilisateur utilisateurcoms, Publication publicationcoms) {
		super();
		this.contenu = contenu;
		this.date_coms = date_coms;
		this.utilisateurcoms = utilisateurcoms;
		this.publicationcoms = publicationcoms;
	}

}
