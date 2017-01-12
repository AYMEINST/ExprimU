package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Note_publication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idNote;
	private Date dateAppreciation;
	private String note;
	
	
	@ManyToOne
	@JoinColumn(name="idPublication")
	private Publication publication;
	
	

	public Note_publication() {
		super();
	}
	
	
	public Long getIdNote() {
		return idNote;
	}




	public void setIdNote(Long idNote) {
		this.idNote = idNote;
	}




	public Date getDateAppreciation() {
		return dateAppreciation;
	}




	public void setDateAppreciation(Date dateAppreciation) {
		this.dateAppreciation = dateAppreciation;
	}




	public String getNote() {
		return note;
	}




	public void setNote(String note) {
		this.note = note;
	}




	public Publication getPublication() {
		return publication;
	}




	public void setPublication(Publication publication) {
		this.publication = publication;
	}


	public Note_publication(Long idNote, Date dateAppreciation, String note, Publication publication) {
		super();
		this.idNote = idNote;
		this.dateAppreciation = dateAppreciation;
		this.note = note;
		this.publication = publication;
	}




}
