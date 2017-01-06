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
//@AssociationOverrides({@AssociationOverride(name="clecompose.idpublication", joinColumns=@JoinColumn(name="idpublication",referencedColumnName="FK.idpublication")),
//@AssociationOverride(name="clecompose.id_utilisateur",joinColumns= @JoinColumn(name="id_utilisateur",referencedColumnName="FK.id_utilisateur"))})
public class Publier implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdPubliRef;
	private Date date_publication;	
	@ManyToOne
	@JoinColumn(name="idpublication")
	private Publication publication ;	
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;
	
	public Long getIdPubliRef() {
		return IdPubliRef;
	}
	public void setIdPubliRef(Long idPubliRef) {
		IdPubliRef = idPubliRef;
	}
	public Date getDate_publication() {
		return date_publication;
	}
	public void setDate_publication(Date date_publication) {
		this.date_publication = date_publication;
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
	public Publier(Long idPubliRef, Date date_publication, Publication publication, Utilisateur utilisateur) {
		super();
		IdPubliRef = idPubliRef;
		this.date_publication = date_publication;
		this.publication = publication;
		this.utilisateur = utilisateur;
	}
	public Publier() {
		super();
	}
	
	
	
	
}
