package org.com.fr.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Fichier extends Element_publication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Byte[] fichier;
	private String libelle;
	
	@ManyToOne
	@JoinColumn(name="idContenu")
	private Contenu contenu;
	
	public Byte[] getFichier() {
		return fichier;
	}
	public void setFichier(Byte[] fichier) {
		this.fichier = fichier;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Fichier(String libele, String attribute) {
		super(libele, attribute);
		// TODO Auto-generated constructor stub
	}
	public Fichier(String libele, String attribute, Byte[] fichier, String libelle, Contenu contenu) {
		super(libele, attribute);
		this.fichier = fichier;
		this.libelle = libelle;
		this.contenu = contenu;
	}

}
