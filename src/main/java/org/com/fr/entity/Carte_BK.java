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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_carte;
	private int numero_bk;
	private Date date_experation;
	
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur_cbk;

	public int getId_carte() {
		return id_carte;
	}

	public void setId_carte(int id_carte) {
		this.id_carte = id_carte;
	}

	public int getNumero_bk() {
		return numero_bk;
	}

	public void setNumero_bk(int numero_bk) {
		this.numero_bk = numero_bk;
	}

	public Date getDate_experation() {
		return date_experation;
	}

	public void setDate_experation(Date date_experation) {
		this.date_experation = date_experation;
	}

	public Utilisateur getUtilisateur_cbk() {
		return utilisateur_cbk;
	}

	public void setUtilisateur_cbk(Utilisateur utilisateur_cbk) {
		this.utilisateur_cbk = utilisateur_cbk;
	}

	public Carte_BK(int numero_bk, Date date_experation, Utilisateur utilisateur_cbk) {
		super();
		this.numero_bk = numero_bk;
		this.date_experation = date_experation;
		this.utilisateur_cbk = utilisateur_cbk;
	}

	public Carte_BK() {
		super();
	}
	

}
