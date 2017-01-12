package org.com.fr.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Element_publication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idElementPublication;
	private String libeleElementP;
	@ManyToOne
	@JoinColumn(name="idPublication")
	private Publication publication;
	
	

	public Long getIdElementPublication() {
		return idElementPublication;
	}
	public void setIdElementPublication(Long idElementPublication) {
		this.idElementPublication = idElementPublication;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public Long getId_elementpub() {
		return idElementPublication;
	}
	public void setId_elementpub(Long id_elementpub) {
		this.idElementPublication = id_elementpub;
	}
	public String getLibele() {
		return libeleElementP;
	}
	public void setLibele(String libele) {
		this.libeleElementP = libele;
	}
	
	
	public Element_publication(String libele) {
		super();
		this.libeleElementP = libele;
		
	}
	public Element_publication() {
		super();
	}
	public Element_publication(Long idElementPublication, String libeleElementP, Publication publication) {
		super();
		this.idElementPublication = idElementPublication;
		this.libeleElementP = libeleElementP;
		this.publication = publication;
	}
	
	
	
	
}
