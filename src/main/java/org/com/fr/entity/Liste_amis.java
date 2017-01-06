package org.com.fr.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Liste_amis implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_amisL;;
	
	@ManyToOne()
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;
	
	public Liste_amis() {
		super();
	}

	public int getId_amisL() {
		return id_amisL;
	}

	public void setId_amisL(int id_amisL) {
		this.id_amisL = id_amisL;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Liste_amis(Utilisateur utilisateur) {
		super();
		this.utilisateur = utilisateur;
	}
	
	
}
