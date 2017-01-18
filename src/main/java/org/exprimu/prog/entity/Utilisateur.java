package org.exprimu.prog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String adresse;
	private String codePostal;
	private Long photo;
	private String profession;
	private String password;
	private String email;
	private boolean statue_compte;

	@OneToMany(mappedBy = "idUtilisateur", fetch = FetchType.LAZY)
	private List<Forum> forums;

	@OneToMany(mappedBy = "utilisateur")
	private List<Commentaire> listCommmentaire;

	@OneToMany(mappedBy = "utilisateur")
	private List<Publication> listPublication;

	@OneToMany(mappedBy = "utilisateur")
	private List<CarteBK> listCarteBk;

	@ManyToOne()
	@JoinColumn(name = "id_notePublication")
	private Publication idNotPublication;

	@OneToMany(mappedBy = "utilisateurR")
	private List<Message> listMessagesR;

	@OneToMany(mappedBy = "utilisateurE")
	private List<Message> listMessagesE;

	@OneToMany(mappedBy = "utilisateurP")
	private List<Amis> amislist;

	@ManyToMany
	@JoinTable(name = "Role_utilisateur", joinColumns = @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur"), inverseJoinColumns = @JoinColumn(name = "idRole", referencedColumnName = "idRole"))
	private List<Roles> ListRoles = new ArrayList<Roles>();

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Long getPhoto() {
		return photo;
	}

	public void setPhoto(Long photo) {
		this.photo = photo;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatue_compte() {
		return statue_compte;
	}

	public void setStatue_compte(boolean statue_compte) {
		this.statue_compte = statue_compte;
	}

	public List<Forum> getForums() {
		return forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
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

	public Publication getIdNotPublication() {
		return idNotPublication;
	}

	public void setIdNotPublication(Publication idNotPublication) {
		this.idNotPublication = idNotPublication;
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

	public List<Roles> getListRoles() {
		return ListRoles;
	}

	public void setListRoles(List<Roles> listRoles) {
		ListRoles = listRoles;
	}

	public Utilisateur() {
		super();
	}

	public Utilisateur( String nom, String prenom, Date dateNaissance, String adresse,
			String codePostal, Long photo, String profession, String password, String email, boolean statue_compte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.photo = photo;
		this.profession = profession;
		this.password = password;
		this.email = email;
		this.statue_compte = statue_compte;
	}

	public List<Amis> getAmislist() {
		return amislist;
	}

	public void setAmislist(List<Amis> amislist) {
		this.amislist = amislist;
	}

	
	
	
	
}
