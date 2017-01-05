package org.com.fr.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
@Entity
@AssociationOverrides({@AssociationOverride(name="clecompose.idpublication", joinColumns=@JoinColumn(name="idpublication",referencedColumnName="FK.idpublication")),
@AssociationOverride(name="clecompose.id_utilisateur",joinColumns= @JoinColumn(name="id_utilisateur",referencedColumnName="FK.id_utilisateur"))})
public class Historique implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private HistoriquePK colecompose;
	public HistoriquePK getColecompose() {
		return colecompose;
	}
	public void setColecompose(HistoriquePK colecompose) {
		this.colecompose = colecompose;
	}
	public Historique(HistoriquePK colecompose) {
		super();
		this.colecompose = colecompose;
	}

}
