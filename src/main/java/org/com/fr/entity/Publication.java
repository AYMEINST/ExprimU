package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Publication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPublication;
	private String titrePublication;
	private Date datePublication;
//	publication coms
	@OneToMany(mappedBy="publication")
	private List<Commentaire> listCommmentaire;
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private  Utilisateur utilisateur;

//	element
	@OneToMany(mappedBy="publication" ,cascade=CascadeType.ALL)
	private List<Element_publication> listElement;
	



	//	element
	@OneToMany(mappedBy="publication" ,cascade=CascadeType.ALL)
	private List<Note_publication> listNote;
	
	public Date getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}
	public List<Element_publication> getListElement() {
		return listElement;
	}
	public void setListElement(List<Element_publication> listElement) {
		this.listElement = listElement;
	}
	public List<Commentaire> getListCommmentaire() {
		return listCommmentaire;
	}
	public void setListCommmentaire(List<Commentaire> listCommmentaire) {
		this.listCommmentaire = listCommmentaire;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Long getIdPublication() {
		return idPublication;
	}
	public void setIdPublication(Long idPublication) {
		this.idPublication = idPublication;
	}
	
	public String getTitrePublication() {
		return titrePublication;
	}
	public void setTitrePublication(String titrePublication) {
		this.titrePublication = titrePublication;
	}
	public List<Commentaire> getListcoms() {
		return listCommmentaire;
	}
	public void setListcoms(List<Commentaire> listcoms) {
		this.listCommmentaire = listcoms;
	}
	
	public List<Note_publication> getListNote() {
		return listNote;
	}
	public void setListNote(List<Note_publication> listNote) {
		this.listNote = listNote;
	}


	
	
	public Publication() {
		super();
	}
	public Publication(Long idPublication, String titrePublication, Date datePublication,
			List<Commentaire> listCommmentaire, Utilisateur utilisateur, List<Element_publication> listElement,
			List<Note_publication> listNote) {
		super();
		this.idPublication = idPublication;
		this.titrePublication = titrePublication;
		this.datePublication = datePublication;
		this.listCommmentaire = listCommmentaire;
		this.utilisateur = utilisateur;
		this.listElement = listElement;
		this.listNote = listNote;
	}
	
	
	
	
	

}
