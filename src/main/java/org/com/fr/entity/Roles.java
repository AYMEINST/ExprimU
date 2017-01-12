package org.com.fr.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Roles {

	@Id
	private String Role ;
	@ManyToMany(mappedBy="ListRoles")
	private List<Utilisateur>utilisateur;
	

	public List<Utilisateur> getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(List<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public Roles(String role, List<Utilisateur> utilisateur) {
		super();
		Role = role;
		this.utilisateur = utilisateur;
	}
	
	
	
	
	
	
}
