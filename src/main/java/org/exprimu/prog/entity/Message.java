package org.exprimu.prog.entity;

import java.io.Serializable;
import java.util.Date;
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
	private Date date;
	@ManyToOne
	@JoinColumn(name = "idUtilisateurE")
	private Utilisateur utilisateurE;
	@ManyToOne
	@JoinColumn(name = "idUtilisateurR")
	private Utilisateur utilisateurR;
	private boolean luE;
	private boolean luR;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public boolean isLuE() {
		return luE;
	}

	public void setLuE(boolean luE) {
		this.luE = luE;
	}

	public boolean isLuR() {
		return luR;
	}

	public void setLuR(boolean luR) {
		this.luR = luR;
	}

	public Message(String objet, Date date, boolean luE, boolean luR, Utilisateur utilisateurE,
			Utilisateur utilisateurR) {
		this.objet = objet;
		this.date = date;
		this.luE = luE;
		this.luR = luR;
		this.utilisateurE = utilisateurE;
		this.utilisateurR = utilisateurR;
	}

	public Message(String objet, Date date, boolean luE, boolean luR) {
		this.objet = objet;
		this.date = date;
		this.luE = luE;
		this.luR = luR;
	}

	public Message() {
	}

}
