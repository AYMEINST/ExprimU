package org.exprimu.prog.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMessage;
	private String objet;
	private String contenueMessage;
	@ManyToOne
	@JoinColumn(name = "idUtilisateurE")
	private Utilisateur utilisateurE;
	@ManyToOne
	@JoinColumn(name = "idUtilisateurR")
	private Utilisateur utilisateurR;

	public Long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getContenueMessage() {
		return contenueMessage;
	}

	public void setContenueMessage(String contenueMessage) {
		this.contenueMessage = contenueMessage;
	}

	public Utilisateur getUtilisateurE() {
		return utilisateurE;
	}

	public void setUtilisateurE(Utilisateur utilisateurE) {
		this.utilisateurE = utilisateurE;
	}

	public Utilisateur getUtilisateurR() {
		return utilisateurR;
	}

	public void setUtilisateurR(Utilisateur utilisateurR) {
		this.utilisateurR = utilisateurR;
	}

	public Message(Long idMessage, String objet, String contenueMessage, Utilisateur utilisateurE,
			Utilisateur utilisateurR) {
		super();
		this.idMessage = idMessage;
		this.objet = objet;
		this.contenueMessage = contenueMessage;
		this.utilisateurE = utilisateurE;
		this.utilisateurR = utilisateurR;
	}

	public Message() {
		super();
	}

}
