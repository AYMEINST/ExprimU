package org.exprimu.prog.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class NotePublication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idNote;
	private Date dateAppreciation;
	private Integer note;
	@ManyToOne
	@JoinColumn(name="idPublication")
	private Publication idPublication;
	
	@OneToMany(mappedBy="idNotPublication")
	private List<Utilisateur> listutilisateur;
	
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
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}


	public Publication getIdPublication() {
		return idPublication;
	}
	public void setIdPublication(Publication idPublication) {
		this.idPublication = idPublication;
	}
	@JsonIgnore
	public List<Utilisateur> getListutilisateur() {
		return listutilisateur;
	}
	public void setListutilisateur(List<Utilisateur> listutilisateur) {
		this.listutilisateur = listutilisateur;
	}
	public NotePublication() {
		super();
	}
	
	

}
