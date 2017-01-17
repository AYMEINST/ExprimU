package org.exprimu.prog.entity;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPublication;
	private String titrePublication;
	private String statuePublication;
	private Date datePublication;
	@OneToMany(mappedBy = "publication")
	private List<Commentaire> listCommmentaire;
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "idPublication", cascade = CascadeType.ALL)
	private List<NotePublication> listNotePublication;
	
	@OneToMany(mappedBy="publication")
	private List<Document> listdocument;
	
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
	public String getStatuePublication() {
		return statuePublication;
	}
	public void setStatuePublication(String statuePublication) {
		this.statuePublication = statuePublication;
	}
	public Date getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
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

	public List<NotePublication> getListNotePublication() {
		return listNotePublication;
	}
	public void setListNotePublication(List<NotePublication> listNotePublication) {
		this.listNotePublication = listNotePublication;
	}
	public List<Document> getListdocument() {
		return listdocument;
	}
	public void setListdocument(List<Document> listdocument) {
		this.listdocument = listdocument;
	}
	public Publication(Long idPublication, String titrePublication, String statuePublication, Date datePublication,
			List<Commentaire> listCommmentaire, Utilisateur utilisateur, List<NotePublication> listNote) {
		super();
		this.idPublication = idPublication;
		this.titrePublication = titrePublication;
		this.statuePublication = statuePublication;
		this.datePublication = datePublication;
		this.listCommmentaire = listCommmentaire;
		this.utilisateur = utilisateur;
	}
	public Publication() {
		super();
	}

	
	

}
