package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Statue extends Element_publication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String LibelleStatue;
	private Date dateStatut;
//	
	
	
	public String getLibelleStatue() {
		return LibelleStatue;
	}
	public void setLibelleStatue(String libelleStatue) {
		LibelleStatue = libelleStatue;
	}
	public Date getDateStatut() {
		return dateStatut;
	}
	public void setDateStatut(Date dateStatut) {
		this.dateStatut = dateStatut;
	}
	
	
	public Statue(String libele, String libelleStatue, Date dateStatut) {
		super(libele);
		LibelleStatue = libelleStatue;
		this.dateStatut = dateStatut;
		
	}
	public Statue(String libele) {
		super(libele);
	}
	
	
	

	
	
	

}
