package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Utilisateur implements Serializable {
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String Nom;
	private String Prenom;
	private Date date_naissance;
	private String adresse;
	private String code_postale;
	private String pays;
	private String login;
	private String motdepasse;
	private String Email;
	@ManyToOne
	@JoinColumn(name="Role")
	private Roles  role;
	private boolean statue_compte;
////	forum uniderctionnel
//	@ManyToOne
//	@JoinColumn(name="id_forum")
//	private Forum forum;
//	commentaire
	@OneToMany(mappedBy="idForum")
	private List<Forum> listForum;
//	commentaire
	@OneToMany(mappedBy="utilisateur")
	private List<Commentaire> listCommmentaire;
//	publication
	@OneToMany(mappedBy="utilisateur")
	private List<Publication> listPublication;
//	carte bancaire
	@OneToMany(mappedBy="utilisateur")
	private List<Carte_BK> listCarteBk;
//	liste amis
	@OneToMany(mappedBy="utilisateur")
	private List<Liste_amis> listeAmis;
//	demande d'ajout
	@OneToMany(mappedBy="utilisateur")
	private List<Demande_ajout> demandeAjout;
//	message
	@ManyToMany
	@JoinTable(name="EnvoyerMSG",joinColumns=@JoinColumn(name="idUtilisateur",referencedColumnName="idUtilisateur"),
			inverseJoinColumns=@JoinColumn(name="idMessage",referencedColumnName="idMessage"))
	private List<Message> listMessages;
	@ManyToMany
	@JoinTable(name="utilisateurRoles",joinColumns=@JoinColumn(name="idUtilisateur",referencedColumnName="idUtilisateur"),
			inverseJoinColumns=@JoinColumn(name="Role",referencedColumnName="Role"))
	private List<Roles> ListRoles;
	private static final long serialVersionUID = 1L;
	
	
	
	public List<Roles> getListRoles() {
		return ListRoles;
	}



	public void setListRoles(List<Roles> listRoles) {
		ListRoles = listRoles;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public List<Forum> getListForum() {
		return listForum;
	}



	public void setListForum(List<Forum> listForum) {
		this.listForum = listForum;
	}



	public List<Message> getListMessages() {
		return listMessages;
	}



	public void setListMessages(List<Message> listMessages) {
		this.listMessages = listMessages;
	}



	public Long getIdUtilisateur() {
		return idUtilisateur;
	}



	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}



	public String getNom() {
		return Nom;
	}



	public void setNom(String nom) {
		Nom = nom;
	}



	public String getPrenom() {
		return Prenom;
	}



	public void setPrenom(String prenom) {
		Prenom = prenom;
	}



	public Date getDate_naissance() {
		return date_naissance;
	}



	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getCode_postale() {
		return code_postale;
	}



	public void setCode_postale(String code_postale) {
		this.code_postale = code_postale;
	}



	public String getPays() {
		return pays;
	}



	public void setPays(String pays) {
		this.pays = pays;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getMotdepasse() {
		return motdepasse;
	}



	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}



	public Roles getRole() {
		return role;
	}



	public void setRole(Roles role) {
		this.role = role;
	}



	public boolean isStatue_compte() {
		return statue_compte;
	}



	public void setStatue_compte(boolean statue_compte) {
		this.statue_compte = statue_compte;
	}



	


	public List<Commentaire> getListCommmentaire() {
		return listCommmentaire;
	}



	@JsonIgnore
	public void setListCommmentaire(List<Commentaire> listCommmentaire) {
		this.listCommmentaire = listCommmentaire;
	}

	public List<Publication> getListPublication() {
		return listPublication;
	}

	@JsonIgnore
	public void setListPublication(List<Publication> listPublication) {
		this.listPublication = listPublication;
	}


	public List<Carte_BK> getListCarteBk() {
		return listCarteBk;
	}


	@JsonIgnore
	public void setListCarteBk(List<Carte_BK> listCarteBk) {
		this.listCarteBk = listCarteBk;
	}



	public List<Liste_amis> getListeAmis() {
		return listeAmis;
	}


	@JsonIgnore
	public void setListeAmis(List<Liste_amis> listeAmis) {
		this.listeAmis = listeAmis;
	}



	public List<Demande_ajout> getDemandeAjout() {
		return demandeAjout;
	}



	public void setDemandeAjout(List<Demande_ajout> demandeAjout) {
		this.demandeAjout = demandeAjout;
	}



	public List<Message> getListMEssages() {
		return listMessages;
	}


	@JsonIgnore
	public void setListMEssages(List<Message> listMEssages) {
		this.listMessages = listMEssages;
	}



	public Utilisateur() {
		super();
	}
	
}
