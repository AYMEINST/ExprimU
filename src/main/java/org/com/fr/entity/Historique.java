package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
//@AssociationOverrides({@AssociationOverride(name="clecompose.idpublication", joinColumns=@JoinColumn(name="idpublication",referencedColumnName="FK.idpublication")),
//@AssociationOverride(name="clecompose.id_utilisateur",joinColumns= @JoinColumn(name="id_utilisateur",referencedColumnName="FK.id_utilisateur"))})
public class Historique implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdHistorique ;
	private Date DateHistorique;
	@OneToMany(mappedBy="id_forum")
	private List<Forum>ListForum;
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;
	
	
	
	public Long getIdHistorique() {
		return IdHistorique;
	}
	public void setIdHistorique(Long idHistorique) {
		IdHistorique = idHistorique;
	}
	public Date getDateHistorique() {
		return DateHistorique;
	}
	public void setDateHistorique(Date dateHistorique) {
		DateHistorique = dateHistorique;
	}
	public List<Forum> getListForum() {
		return ListForum;
	}
	public void setListForum(List<Forum> listForum) {
		ListForum = listForum;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Historique(Long idHistorique, Date dateHistorique, List<Forum> listForum, Utilisateur utilisateur) {
		super();
		IdHistorique = idHistorique;
		DateHistorique = dateHistorique;
		ListForum = listForum;
		this.utilisateur = utilisateur;
	}
	public Historique() {
		super();
	}
	
	

}
