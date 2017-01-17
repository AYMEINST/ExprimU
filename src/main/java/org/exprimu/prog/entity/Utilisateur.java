package org.exprimu.prog.entity;

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
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private Date date_naissance;
	private String adresseUtilisateur;
	private String codePostalUtilisateur;
	private Long photoUtilisateur;
	private String ProfessionUtilisateur;
	private String motdepasse;
	private String EmailUtilisateur;
	@ManyToOne
	@JoinColumn(name="Role")
	private Roles  role;
	private boolean statue_compte;
////	forum uniderctionnel
//	@ManyToOne
//	@JoinColumn(name="id_forum")
//	private Forum forum;
//	commentaire
	@OneToMany(mappedBy="utilisateurForum")
	private List<Forum> listForum;
//	commentaire
	@OneToMany(mappedBy="utilisateur")
	private List<Commentaire> listCommmentaire;
//	publication
	@OneToMany(mappedBy="utilisateur")
	private List<Publication> listPublication;
//	carte bancaire
	@OneToMany(mappedBy="utilisateur")
	private List<CarteBK> listCarteBk;
	
	@ManyToOne()
	@JoinColumn(name="id_notePublication")
	private Publication idNotPublication;
	
	@OneToMany(mappedBy="utilisateurR")
	private List<Message> listMessagesR;
	
	@OneToMany(mappedBy="utilisateurE")
	private List<Message> listMessagesE;
	
	@ManyToOne
	@JoinColumn(name="idListAmis")
    private  Amis amislist; 
	
	@ManyToMany
	@JoinTable(name="utilisateurRoles",joinColumns=@JoinColumn(name="idUtilisateur",referencedColumnName="idUtilisateur"),
			inverseJoinColumns=@JoinColumn(name="idRole",referencedColumnName="idRole"))
	private List<Roles> ListRoles;
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}
	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getAdresseUtilisateur() {
		return adresseUtilisateur;
	}
	public void setAdresseUtilisateur(String adresseUtilisateur) {
		this.adresseUtilisateur = adresseUtilisateur;
	}
	public String getCodePostalUtilisateur() {
		return codePostalUtilisateur;
	}
	public void setCodePostalUtilisateur(String codePostalUtilisateur) {
		this.codePostalUtilisateur = codePostalUtilisateur;
	}
	public Long getPhotoUtilisateur() {
		return photoUtilisateur;
	}
	public void setPhotoUtilisateur(Long photoUtilisateur) {
		this.photoUtilisateur = photoUtilisateur;
	}
	public String getProfessionUtilisateur() {
		return ProfessionUtilisateur;
	}
	public void setProfessionUtilisateur(String professionUtilisateur) {
		ProfessionUtilisateur = professionUtilisateur;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	public String getEmailUtilisateur() {
		return EmailUtilisateur;
	}
	public void setEmailUtilisateur(String emailUtilisateur) {
		EmailUtilisateur = emailUtilisateur;
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
	public List<Forum> getListForum() {
		return listForum;
	}
	public void setListForum(List<Forum> listForum) {
		this.listForum = listForum;
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
	public List<CarteBK> getListCarteBk() {
		return listCarteBk;
	}
	public void setListCarteBk(List<CarteBK> listCarteBk) {
		this.listCarteBk = listCarteBk;
	}
	
	public List<Message> getListMessagesR() {
		return listMessagesR;
	}
	public void setListMessagesR(List<Message> listMessagesR) {
		this.listMessagesR = listMessagesR;
	}
	public List<Message> getListMessagesE() {
		return listMessagesE;
	}
	public void setListMessagesE(List<Message> listMessagesE) {
		this.listMessagesE = listMessagesE;
	}
	public Amis getAmislist() {
		return amislist;
	}
	public void setAmislist(Amis amislist) {
		this.amislist = amislist;
	}
	public List<Roles> getListRoles() {
		return ListRoles;
	}
	public void setListRoles(List<Roles> listRoles) {
		ListRoles = listRoles;
	}

	
	
	

}
