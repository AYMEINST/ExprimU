package org.com.fr.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Forum implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idForum;
	@ManyToOne()
	@JoinColumn(name="idPublication")
	private Publication publicationForum;
	
	
	public Forum() {
		super();
	}


	public Forum(Long idForum, Publication publicationForum) {
		super();
		this.idForum = idForum;
		this.publicationForum = publicationForum;
	}


	public Long getIdForum() {
		return idForum;
	}


	public void setIdForum(Long idForum) {
		this.idForum = idForum;
	}


	public Publication getPublicationForum() {
		return publicationForum;
	}


	public void setPublicationForum(Publication publicationForum) {
		this.publicationForum = publicationForum;
	}
	
	
	
	
}
