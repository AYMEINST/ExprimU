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
public class Document implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDocument;
	private String descriptionFichier;
	private Long idFichier;
	private Date dateCreation;
	
	@ManyToOne()
	@JoinColumn(name="idPublication")
	private Publication publication;
	
	
	public Long getIdDocument() {
		return idDocument;
	}


	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}


	public String getDescriptionFichier() {
		return descriptionFichier;
	}


	public void setDescriptionFichier(String descriptionFichier) {
		this.descriptionFichier = descriptionFichier;
	}


	public Long getIdFichier() {
		return idFichier;
	}


	public void setIdFichier(Long idFichier) {
		this.idFichier = idFichier;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Publication getPublication() {
		return publication;
	}


	public void setPublication(Publication publication) {
		this.publication = publication;
	}


	public Document(String descriptionFichier, Long idFichier, Date dateCreation,
			Publication publication) {
		super();
		this.descriptionFichier = descriptionFichier;
		this.idFichier = idFichier;
		this.dateCreation = dateCreation;
		this.publication = publication;
	}


	public Document() {
		super();
	}

}
