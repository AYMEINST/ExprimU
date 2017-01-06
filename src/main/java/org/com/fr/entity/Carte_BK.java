package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Carte_BK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCarte;
	private int numeroCarteBk;
	private Date dateExperation;	
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;

	

	public Carte_BK(Long idCarte, int numeroCarteBk, Date dateExperation, Utilisateur utilisateur) {
		super();
		this.idCarte = idCarte;
		this.numeroCarteBk = numeroCarteBk;
		this.dateExperation = dateExperation;
		this.utilisateur = utilisateur;
	}



	public Carte_BK() {
		super();
	}



	
	public Long getIdCarte() {
		return idCarte;
	}



	public void setIdCarte(Long idCarte) {
		this.idCarte = idCarte;
	}



	public int getNumeroCarteBk() {
		return numeroCarteBk;
	}



	public void setNumeroCarteBk(int numeroCarteBk) {
		this.numeroCarteBk = numeroCarteBk;
	}



	public Date getDateExperation() {
		return dateExperation;
	}



	public void setDateExperation(Date dateExperation) {
		this.dateExperation = dateExperation;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

}
