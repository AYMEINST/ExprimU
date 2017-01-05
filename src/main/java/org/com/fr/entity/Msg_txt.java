package org.com.fr.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Msg_txt extends Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String contenu_txt;
	public String getContenu() {
		return contenu_txt;
	}
	public void setContenu(String contenu) {
		this.contenu_txt = contenu;
	}
	public Msg_txt() {
		super();
	}
	
	

}
