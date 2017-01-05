package org.com.fr.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Element_publication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_elementpub;
	private String libele;
	private String attribute;
	public int getId_elementpub() {
		return id_elementpub;
	}
	public void setId_elementpub(int id_elementpub) {
		this.id_elementpub = id_elementpub;
	}
	public String getLibele() {
		return libele;
	}
	public void setLibele(String libele) {
		this.libele = libele;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public Element_publication(String libele, String attribute) {
		super();
		this.libele = libele;
		this.attribute = attribute;
	}
	public Element_publication() {
		super();
	}
	
}
