package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Statue extends Element_publication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dateStatut;
	@ManyToOne
	@JoinColumn(name="idPublication")
	private Publication publication;
	
	
	public Date getDateStatut() {
		return dateStatut;
	}
	public void setDateStatut(Date dateStatut) {
		this.dateStatut = dateStatut;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	
	public Statue(String libele, String attribute, Date dateStatut, Publication publication) {
		super(libele, attribute);
		this.dateStatut = dateStatut;
		this.publication = publication;
	}
	public Statue(String libele, String attribute) {
		super(libele, attribute);
	}

	
	
	

}
