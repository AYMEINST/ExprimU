package org.exprimu.prog.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Roles implements Serializable{

	@Id
	private Long idRole;
	private String libelleRole;
	@ManyToMany(mappedBy = "ListRoles")
	private List<Utilisateur> utilisateur;

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getLibelleRole() {
		return libelleRole;
	}

	public void setLibelleRole(String libelleRole) {
		this.libelleRole = libelleRole;
	}

	public List<Utilisateur> getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(List<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Roles(Long idRole, String libelleRole, List<Utilisateur> utilisateur) {
		super();
		this.idRole = idRole;
		this.libelleRole = libelleRole;
		this.utilisateur = utilisateur;
	}

	public Roles() {
		super();
	}

}
