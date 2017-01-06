package org.com.fr.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles {

	@Id
	private Long IdRole;
	private String libelleRole ;
	
	
	public Roles(Long idRole, String libelleRole) {
		super();
		IdRole = idRole;
		this.libelleRole = libelleRole;
	}


	public Roles() {
		super();
	}


	public Long getIdRole() {
		return IdRole;
	}


	public void setIdRole(Long idRole) {
		IdRole = idRole;
	}


	public String getLibelleRole() {
		return libelleRole;
	}


	public void setLibelleRole(String libelleRole) {
		this.libelleRole = libelleRole;
	}
	
	
	
}
