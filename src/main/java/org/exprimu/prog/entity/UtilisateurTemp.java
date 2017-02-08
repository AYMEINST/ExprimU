package org.exprimu.prog.entity;

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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UtilisateurTemp implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateurTemp;
	private String nomUtilisateurTemp;
	private String prenomUtilisateurTemp;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateUtilisateur;
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


	public UtilisateurTemp() {
		super();
	}

	public UtilisateurTemp(String nomUtilisateurTemp, String prenomUtilisateurTemp, Date dateUtilisateur,
			String motdepasse, String emailUtilisateurTemp) {
		super();
		this.nomUtilisateurTemp = nomUtilisateurTemp;
		this.prenomUtilisateurTemp = prenomUtilisateurTemp;
		this.dateUtilisateur = dateUtilisateur;
		this.motdepasse = motdepasse;
		this.emailUtilisateurTemp = emailUtilisateurTemp;
	}

	public Date getDateUtilisateur() {
		return dateUtilisateur;
	}

	public void setDateUtilisateur(Date dateUtilisateur) {
		this.dateUtilisateur = dateUtilisateur;
	}


	
}
