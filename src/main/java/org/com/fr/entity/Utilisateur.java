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
	@ManyToOne
	@JoinColumn(name="IdRole")
	private Roles  role;
	private boolean statue_compte;
//	forum uniderctionnel
	@ManyToOne
	@JoinColumn(name="id_forum")
	private Forum forum;
//	commentaire
	@OneToMany(mappedBy="idCommentaire")
	private List<Commentaire> listCommmentaire;
//	publication
	@OneToMany(mappedBy="idPublication")
	private List<Publication> listPublication;
//	carte bancaire
	@OneToMany(mappedBy="numeroCarteBk")
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
	private static final long serialVersionUID = 1L;
	
	
	
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



	public Forum getForum() {
		return forum;
	}



	public void setForum(Forum forum) {
		this.forum = forum;
	}



	public List<Commentaire> getListCommmentaire() {
		return listCommmentaire;
	}



	public void setListCommmentaire(List<Commentaire> listCommmentaire) {
		this.listCommmentaire = listCommmentaire;
	}



	public List<Publication> getListPublication() {
		return listPublication;
	}



	public void setListPublication(List<Publication> listPublication) {
		this.listPublication = listPublication;
	}



	public List<Carte_BK> getListCarteBk() {
		return listCarteBk;
	}



	public void setListCarteBk(List<Carte_BK> listCarteBk) {
		this.listCarteBk = listCarteBk;
	}



	public List<Liste_amis> getListeAmis() {
		return listeAmis;
	}



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



	public void setListMEssages(List<Message> listMEssages) {
		this.listMessages = listMEssages;
	}



	public Utilisateur() {
		super();
	}
	
}
