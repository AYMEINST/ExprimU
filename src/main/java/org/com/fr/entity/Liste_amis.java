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
	private int idListAmis;;
	
	@ManyToOne()
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;
	
	public Liste_amis() {
		super();
	}
	
	public Liste_amis(int idListAmis, Utilisateur utilisateur) {
		super();
		this.idListAmis = idListAmis;
		this.utilisateur = utilisateur;
	}

	public int getIdListAmis() {
		return idListAmis;
	}

	public void setIdListAmis(int idListAmis) {
		this.idListAmis = idListAmis;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	

	
	
	
}
