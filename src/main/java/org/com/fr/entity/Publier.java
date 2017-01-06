package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Publier implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPubliRef;
	private Date datePublication;	
	@ManyToOne
	@JoinColumn(name="idPublication")
	private Publication publication ;	
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;
	public Long getIdPubliRef() {
		return idPubliRef;
	}
	public void setIdPubliRef(Long idPubliRef) {
		this.idPubliRef = idPubliRef;
	}
	public Date getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Publier(Long idPubliRef, Date datePublication, Publication publication, Utilisateur utilisateur) {
		super();
		this.idPubliRef = idPubliRef;
		this.datePublication = datePublication;
		this.publication = publication;
		this.utilisateur = utilisateur;
	}
	public Publier() {
		super();
	}
	
	
	
	
	
	
	
}
