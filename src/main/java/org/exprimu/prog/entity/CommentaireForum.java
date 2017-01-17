package org.exprimu.prog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommentaireForum implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommentaireForum;
	private String contenueCommentaire;
	private Byte[] fichierCommentaire;
	private Date datetimeCommentaire;
	@ManyToOne
	@JoinColumn(name = "idForum")
	private Forum forum;

	public Long getIdCommentaireForum() {
		return idCommentaireForum;
	}

	public void setIdCommentaireForum(Long idCommentaireForum) {
		this.idCommentaireForum = idCommentaireForum;
	}

	public String getContenueCommentaire() {
		return contenueCommentaire;
	}

	public void setContenueCommentaire(String contenueCommentaire) {
		this.contenueCommentaire = contenueCommentaire;
	}

	public Byte[] getFichierCommentaire() {
		return fichierCommentaire;
	}

	public void setFichierCommentaire(Byte[] fichierCommentaire) {
		this.fichierCommentaire = fichierCommentaire;
	}

	public Date getDatetimeCommentaire() {
		return datetimeCommentaire;
	}

	public void setDatetimeCommentaire(Date datetimeCommentaire) {
		this.datetimeCommentaire = datetimeCommentaire;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public CommentaireForum(Long idCommentaireForum, String contenueCommentaire, Byte[] fichierCommentaire,
			Date datetimeCommentaire, Forum forum) {
		super();
		this.idCommentaireForum = idCommentaireForum;
		this.contenueCommentaire = contenueCommentaire;
		this.fichierCommentaire = fichierCommentaire;
		this.datetimeCommentaire = datetimeCommentaire;
		this.forum = forum;
	}

	public CommentaireForum() {
		super();
	}

}
