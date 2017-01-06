package org.com.fr.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Demande_ajout implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_demande;
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;
	public Long getId_demande() {
		return id_demande;
	}
	public void setId_demande(Long id_demande) {
		this.id_demande = id_demande;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Demande_ajout(Utilisateur utilisateur) {
		super();
		this.utilisateur = utilisateur;
	}
	public Demande_ajout() {
		super();
	}
	

}
