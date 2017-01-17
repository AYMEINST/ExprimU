package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Amis implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAmisList;
	private Date dateCreation;

	@ManyToOne
	@JoinColumn(name = "idUtilisateurP")
	private Utilisateur utilisateurP;
	
	@ManyToOne
	@JoinColumn(name = "idUtilisateurA")
	private Utilisateur utilisateurA;

	public Long getIdAmis() {
		return idAmisList;
	}

	public void setIdAmis(Long idAmis) {
		this.idAmisList = idAmis;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Utilisateur getUtilisateurP() {
		return utilisateurP;
	}

	public void setUtilisateurP(Utilisateur utilisateurP) {
		this.utilisateurP = utilisateurP;
	}



	public Amis() {
		super();
	}

}
