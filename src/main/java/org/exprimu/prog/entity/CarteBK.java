package org.exprimu.prog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CarteBK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCarte;
	private Long numeroCarteBk;
	private Date dateExperation;	
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;

	

	public CarteBK(Long idCarte, Long numeroCarteBk, Date dateExperation, Utilisateur utilisateur) {
		super();
		this.idCarte = idCarte;
		this.numeroCarteBk = numeroCarteBk;
		this.dateExperation = dateExperation;
		this.utilisateur = utilisateur;
	}



	public CarteBK() {
		super();
	}



	
	public Long getIdCarte() {
		return idCarte;
	}



	public void setIdCarte(Long idCarte) {
		this.idCarte = idCarte;
	}



	public Long getNumeroCarteBk() {
		return numeroCarteBk;
	}



	public void setNumeroCarteBk(Long numeroCarteBk) {
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
