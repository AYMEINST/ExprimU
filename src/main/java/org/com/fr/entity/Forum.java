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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_forum;
	@ManyToOne()
	@JoinColumn(name="idpublication")
	private Publication publicationform;
	public Forum(Publication publicationform) {
		super();
		this.publicationform = publicationform;
	}
	public Publication getPublicationform() {
		return publicationform;
	}
	public void setPublicationform(Publication publicationform) {
		this.publicationform = publicationform;
	}
	
}
