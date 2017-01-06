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
	private Long idpublication;
	private String contenu_pub;
	private String titre_pub;
//	publication coms
	@OneToMany(mappedBy="publicationcoms")
	private List<Commentaire> listcoms;
//	publication forum
	@OneToMany(mappedBy="publicationform")
	private List<Forum> lisforum;
//	note publication
	@OneToOne
	@JoinColumn(name="note_publication")
	private Note_publication note_pub;
//	contenu
	@OneToMany(mappedBy="publication")
	private List<Contenu> listcontenu;
//	statue
	@OneToMany(mappedBy="publication")
	private List<Statue> liststatue;
	public Long getIdpublication() {
		return idpublication;
	}
	public void setIdpublication(Long idpublication) {
		this.idpublication = idpublication;
	}
	public String getContenu_pub() {
		return contenu_pub;
	}
	public void setContenu_pub(String contenu_pub) {
		this.contenu_pub = contenu_pub;
	}
	public String getTitre_pub() {
		return titre_pub;
	}
	public void setTitre_pub(String titre_pub) {
		this.titre_pub = titre_pub;
	}
	public List<Commentaire> getListcoms() {
		return listcoms;
	}
	public void setListcoms(List<Commentaire> listcoms) {
		this.listcoms = listcoms;
	}
	public Note_publication getNote_pub() {
		return note_pub;
	}
	public void setNote_pub(Note_publication note_pub) {
		this.note_pub = note_pub;
	}
	public List<Contenu> getListcontenu() {
		return listcontenu;
	}
	public void setListcontenu(List<Contenu> listcontenu) {
		this.listcontenu = listcontenu;
	}
	public List<Statue> getListstatue() {
		return liststatue;
	}
	public void setListstatue(List<Statue> liststatue) {
		this.liststatue = liststatue;
	}
	public Publication() {
		super();
	}

}
