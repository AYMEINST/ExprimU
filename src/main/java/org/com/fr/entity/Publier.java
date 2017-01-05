package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;



@Entity
//@AssociationOverrides({@AssociationOverride(name="clecompose.idpublication", joinColumns=@JoinColumn(name="idpublication",referencedColumnName="FK.idpublication")),
//@AssociationOverride(name="clecompose.id_utilisateur",joinColumns= @JoinColumn(name="id_utilisateur",referencedColumnName="FK.id_utilisateur"))})
public class Publier implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private PublierPK clecompose ;
	private Date date_publication;
	public PublierPK getClecompose() {
		return clecompose;
	}
	public void setClecompose(PublierPK clecompose) {
		this.clecompose = clecompose;
	}
	public Date getDate_publication() {
		return date_publication;
	}
	public void setDate_publication(Date date_publication) {
		this.date_publication = date_publication;
	}
	
}
