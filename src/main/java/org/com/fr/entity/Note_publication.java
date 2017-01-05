package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Note_publication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_note;
	private Date date_appreciation;
	private String note;
	
	@OneToOne(mappedBy="note_pub")
	private Publication publication;
	
	public int getId_note() {
		return id_note;
	}
	public void setId_note(int id_note) {
		this.id_note = id_note;
	}
	public Date getDate_appreciation() {
		return date_appreciation;
	}
	public void setDate_appreciation(Date date_appreciation) {
		this.date_appreciation = date_appreciation;
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
	public Note_publication(Date date_appreciation, String note, Publication publication) {
		super();
		this.date_appreciation = date_appreciation;
		this.note = note;
		this.publication = publication;
	}
	public Note_publication() {
		super();
	}
	
}
