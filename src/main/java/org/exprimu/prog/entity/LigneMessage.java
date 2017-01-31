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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LigneMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLigneMessage;
	private String contenue;
	private Date dateEnvoie;
	@ManyToOne
	@JoinColumn(name = "idMessage")
	private Message idMessage;
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;
	
	public Long getIdLigneMessage() {
		return idLigneMessage;
	}

	public void setIdLigneMessage(Long idLigneMessage) {
		this.idLigneMessage = idLigneMessage;
	}

	public String getContenue() {
		return contenue;
	}

	public void setContenue(String contenue) {
		this.contenue = contenue;
	}

	public Date getDateEnvoie() {
		return dateEnvoie;
	}

	public void setDateEnvoie(Date dateEnvoie) {
		this.dateEnvoie = dateEnvoie;
	}

	@JsonIgnore
	public Message getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Message idMessage) {
		this.idMessage = idMessage;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public LigneMessage(String contenue, Date dateEnvoie) {
		this.contenue = contenue;
		this.dateEnvoie = dateEnvoie;
	}

	public LigneMessage(String contenue, Date dateEnvoie, Utilisateur utilisateur, Message idMessage) {
		this.contenue = contenue;
		this.dateEnvoie = dateEnvoie;
		this.utilisateur = utilisateur;
		this.idMessage = idMessage;
	}

	public LigneMessage() {
	}

}