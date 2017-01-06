package org.com.fr.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Contenu extends Element_publication implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	publication
	@ManyToOne
	@JoinColumn(name="idPublication")
	private Publication publication;
//	fichier
	@OneToMany(mappedBy="contenu")
	private List<Fichier> listFichiers;
	
	
	public Contenu(String libele, String attribute) {
		super(libele, attribute);
		// TODO Auto-generated constructor stub
	}
	public Contenu(String libele, String attribute, Publication publication, List<Fichier> listFichiers) {
		super(libele, attribute);
		this.publication = publication;
		this.listFichiers = listFichiers;
	}
	
		
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public List<Fichier> getListfichiers() {
		return listFichiers;
	}
	public void setListfichiers(List<Fichier> listfichiers) {
		this.listFichiers = listfichiers;
	}

	
}
