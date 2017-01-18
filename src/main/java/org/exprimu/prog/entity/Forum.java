package org.exprimu.prog.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Forum implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idForum;
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date dateCreation;
	private String theme;
	private String titre;
	private String description;

	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur idUtilisateur;
	@OneToMany(mappedBy = "idForum", fetch = FetchType.LAZY)
	private List<ForumCommentaire> forumCommentaires;
	

	public void setIdUtilisateur(Utilisateur idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Long getIdForum() {
		return idForum;
	}

	public void setIdForum(Long idForum) {
		this.idForum = idForum;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public Utilisateur getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setUtilisateur(Utilisateur idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@JsonIgnore
	public List<ForumCommentaire> getForumCommentaires() {
		return forumCommentaires;
	}

	public void setForumCommentaires(List<ForumCommentaire> forumCommentaires) {
		this.forumCommentaires = forumCommentaires;
	}

	public Forum(Date dateCreation, String theme, String titre, String description) {
		super();
		this.dateCreation = dateCreation;
		this.theme = theme;
		this.titre = titre;
		this.description = description;
	}

	public Forum() {
		super();
	}

}
