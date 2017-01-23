package org.exprimu.prog.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ForumCommentaire implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idForumCommentaire;
	private String text;
	private Date dateCreation;
	@ManyToOne
	@JoinColumn(name = "id_form")
	private Forum idForum;
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur idUtilisateur;

	public Utilisateur getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Utilisateur idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Long getIdForumCommentaire() {
		return idForumCommentaire;
	}

	public void setIdForumCommentaire(Long idForumCommentaire) {
		this.idForumCommentaire = idForumCommentaire;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@JsonIgnore
	public Forum getIdForum() {
		return idForum;
	}

	public void setIdForum(Forum idForum) {
		this.idForum = idForum;
	}

	public ForumCommentaire(String text, Date dateCreation) {
		super();
		this.text = text;
		this.dateCreation = dateCreation;
	}

	public ForumCommentaire() {
		super();
	}

}
