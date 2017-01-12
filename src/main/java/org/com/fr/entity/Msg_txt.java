package org.com.fr.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Msg_txt extends Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String contenuText;
	
	
	public String getContenuText() {
		return contenuText;
	}


	public void setContenuText(String contenuText) {
		this.contenuText = contenuText;
	}


	public Msg_txt() {
		super();
	}
	
	

}
