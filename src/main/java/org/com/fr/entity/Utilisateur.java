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
	private static final long serialVersionUID = 1L;
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public List<Commentaire> getListcoms() {
		return listcoms;
	}
	public void setListcoms(List<Commentaire> listcoms) {
		this.listcoms = listcoms;
	}
	public List<Carte_BK> getListcarte_bk() {
		return listcarte_bk;
	}
	public void setListcarte_bk(List<Carte_BK> listcarte_bk) {
		this.listcarte_bk = listcarte_bk;
	}
	public List<Liste_amis> getListeamis() {
		return listeamis;
	}
	public void setListeamis(List<Liste_amis> listeamis) {
		this.listeamis = listeamis;
	}
	public List<Demande_ajout> getDemande_ajt() {
		return demande_ajt;
	}
	public void setDemande_ajt(List<Demande_ajout> demande_ajt) {
		this.demande_ajt = demande_ajt;
	}
	public List<Message> getListMEssages() {
		return listMEssages;
	}
	public void setListMEssages(List<Message> listMEssages) {
		this.listMEssages = listMEssages;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_utilisateur;
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
	@OneToMany(mappedBy="utilisateurcoms")
	private List<Commentaire> listcoms;
//	carte bancaire
	@OneToMany(mappedBy="utilisateur_cbk")
	private List<Carte_BK> listcarte_bk;
//	liste amis
	@OneToMany(mappedBy="utilisateur")
	private List<Liste_amis> listeamis;
//	demande d'ajout
	@OneToMany(mappedBy="utilisateur")
	private List<Demande_ajout> demande_ajt;
//	message
	@ManyToMany
	@JoinTable(name="EnvoyerMSG",joinColumns=@JoinColumn(name="id_utilisateur",referencedColumnName="id_utilisateur"),
			inverseJoinColumns=@JoinColumn(name="idmessage",referencedColumnName="idmessage"))
	private List<Message> listMEssages;
	
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
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
	public boolean isStatue_compte() {
		return statue_compte;
	}
	public void setStatue_compte(boolean statue_compte) {
		this.statue_compte = statue_compte;
	}
	
	
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	
	public Utilisateur() {
		super();
	}
	
}
