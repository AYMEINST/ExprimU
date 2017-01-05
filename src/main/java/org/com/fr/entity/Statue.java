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
	private Date date_statut;
	@ManyToOne
	@JoinColumn(name="id_publication")
	private Publication publication;

	public Statue(String libele, String attribute) {
		super(libele, attribute);
		// TODO Auto-generated constructor stub
	}

	public Date getDate_statut() {
		return date_statut;
	}

	public void setDate_statut(Date date_statut) {
		this.date_statut = date_statut;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	

}
