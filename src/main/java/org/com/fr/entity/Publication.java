package org.com.fr.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Publication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPublication;
	private String contenuPublication;
	private String titrePublication;
//	publication coms
	@OneToMany(mappedBy="publication")
	private List<Commentaire> listCommmentaire;
//	publication forum
//	@OneToMany(mappedBy="publicationForum")
//	private List<Forum> listForum;
//	note publication
	@OneToOne
	@JoinColumn(name="notePublication")
	private Note_publication notePublication;

//	statue
	@OneToMany(mappedBy="publication")
	private List<Statue> listStatue;
	
	
	
	public Long getIdPublication() {
		return idPublication;
	}
	public void setIdPublication(Long idPublication) {
		this.idPublication = idPublication;
	}
	public String getContenuPublication() {
		return contenuPublication;
	}
	public void setContenuPublication(String contenuPublication) {
		this.contenuPublication = contenuPublication;
	}
	public String getTitrePublication() {
		return titrePublication;
	}
	public void setTitrePublication(String titrePublication) {
		this.titrePublication = titrePublication;
	}
	public List<Commentaire> getListcoms() {
		return listCommmentaire;
	}
	public void setListcoms(List<Commentaire> listcoms) {
		this.listCommmentaire = listcoms;
	}
	public Note_publication getNotePublication() {
		return notePublication;
	}
	public void setNotePublication(Note_publication notePublication) {
		this.notePublication = notePublication;
	}
	
	public List<Statue> getListStatue() {
		return listStatue;
	}
	public void setListStatue(List<Statue> listStatue) {
		this.listStatue = listStatue;
	}
	
	
	public Publication(Long idPublication, String contenuPublication, String titrePublication,
			List<Commentaire> listcoms, List<Forum> listForum, Note_publication notePublication,
			 List<Statue> listStatue) {
		super();
		this.idPublication = idPublication;
		this.contenuPublication = contenuPublication;
		this.titrePublication = titrePublication;
		this.listCommmentaire = listcoms;
		this.notePublication = notePublication;
		this.listStatue = listStatue;
	}
	
	public Publication() {
		super();
	}
	
	
	
	

}
