package org.com.fr.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Fichier implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFichier;
	private Integer size;
	private String type;
	private String name;
	private Byte[] date;
	public Long getIdFichier() {
		return idFichier;
	}
	public void setIdFichier(Long idFichier) {
		this.idFichier = idFichier;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Byte[] getDate() {
		return date;
	}
	public void setDate(Byte[] date) {
		this.date = date;
	}
	public Fichier(Long idFichier, Integer size, String type, String name, Byte[] date) {
		super();
		this.idFichier = idFichier;
		this.size = size;
		this.type = type;
		this.name = name;
		this.date = date;
	}
	public Fichier() {
		super();
	}
	
	

}
