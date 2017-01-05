package org.com.fr.entity;

import java.io.Serializable;

public class Msg_joint extends Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contenu_jtn;

	public String getContenu_jtn() {
		return contenu_jtn;
	}

	public void setContenu_jtn(String contenu_jtn) {
		this.contenu_jtn = contenu_jtn;
	}

	public Msg_joint(String contenu_jtn) {
		super();
		this.contenu_jtn = contenu_jtn;
	}

	public Msg_joint() {
		super();
	}
	

}
