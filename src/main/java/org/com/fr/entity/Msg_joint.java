package org.com.fr.entity;

import java.io.Serializable;

public class Msg_joint extends Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contenuJoint;

	
	public String getContenuJoint() {
		return contenuJoint;
	}


	public void setContenuJoint(String contenuJoint) {
		this.contenuJoint = contenuJoint;
	}


	
	public Msg_joint(String contenuJoint) {
		super();
		this.contenuJoint = contenuJoint;
	}


	public Msg_joint() {
		super();
	}
	

}
