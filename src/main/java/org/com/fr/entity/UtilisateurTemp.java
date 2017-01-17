package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UtilisateurTemp implements Serializable {
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateurTemp;
	private String nomUtilisateurTemp;
	private String prenomUtilisateurTemp;
	private String motdepasse;
	private String emailUtilisateurTemp;
//	@ManyToOne
//	@JoinColumn(name = "idUtilisateur")
//	private Utilisateur utilisateur;

	public Long getIdUtilisateurTemp() {
		return idUtilisateurTemp;
	}

	public void setIdUtilisateurTemp(Long idUtilisateurTemp) {
		this.idUtilisateurTemp = idUtilisateurTemp;
	}

	public String getNomUtilisateurTemp() {
		return nomUtilisateurTemp;
	}

	public void setNomUtilisateurTemp(String nomUtilisateurTemp) {
		this.nomUtilisateurTemp = nomUtilisateurTemp;
	}

	public String getPrenomUtilisateurTemp() {
		return prenomUtilisateurTemp;
	}

	public void setPrenomUtilisateurTemp(String prenomUtilisateurTemp) {
		this.prenomUtilisateurTemp = prenomUtilisateurTemp;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getEmailUtilisateurTemp() {
		return emailUtilisateurTemp;
	}

	public void setEmailUtilisateurTemp(String emailUtilisateurTemp) {
		this.emailUtilisateurTemp = emailUtilisateurTemp;
	}

//	public Utilisateur getUtilisateur() {
//		return utilisateur;
//	}
//
//	public void setUtilisateur(Utilisateur utilisateur) {
//		this.utilisateur = utilisateur;
//	}

	public UtilisateurTemp() {
		super();
	}

	public UtilisateurTemp(Long idUtilisateurTemp, String nomUtilisateurTemp, String prenomUtilisateurTemp,
			String motdepasse, String emailUtilisateurTemp) {
		super();
		this.idUtilisateurTemp = idUtilisateurTemp;
		this.nomUtilisateurTemp = nomUtilisateurTemp;
		this.prenomUtilisateurTemp = prenomUtilisateurTemp;
		this.motdepasse = motdepasse;
		this.emailUtilisateurTemp = emailUtilisateurTemp;
	}

}
