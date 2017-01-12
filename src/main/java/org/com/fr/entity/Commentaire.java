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
	private Long idCommentaire;
	private String  contenuCommentaire;
	private Date dateCommentaire;
	@ManyToOne()
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;
//	publication
	@ManyToOne()
	@JoinColumn(name="idPublication")
	private Publication publication;
	
	
	public Long getIdCommentaire() {
		return idCommentaire;
	}
	public void setIdCommentaire(Long idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
	public String getContenuCommentaire() {
		return contenuCommentaire;
	}
	public void setContenuCommentaire(String contenuCommentaire) {
		this.contenuCommentaire = contenuCommentaire;
	}
	public Date getDateCommentaire() {
		return dateCommentaire;
	}
	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public Commentaire(Long idCommentaire, String contenuCommentaire, Date dateCommentaire, Utilisateur utilisateur,
			Publication publication) {
		super();
		this.idCommentaire = idCommentaire;
		this.contenuCommentaire = contenuCommentaire;
		this.dateCommentaire = dateCommentaire;
		this.utilisateur = utilisateur;
		this.publication = publication;
	}
	public Commentaire() {
		super();
	}
	
	
	
	
	
	

}
