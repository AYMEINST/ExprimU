package org.com.fr.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idmessage;
	
	@ManyToMany(mappedBy="listMEssages")
	private List<Utilisateur> utilisateurs;
	
	public Message() {
		super();
	}
	public int getIdmessage() {
		return idmessage;
	}
	public void setIdmessage(int idmessage) {
		this.idmessage = idmessage;
	}
	public Message(List<Utilisateur> utilisateurs) {
		super();
		this.utilisateurs = utilisateurs;
	}
	
	
}
