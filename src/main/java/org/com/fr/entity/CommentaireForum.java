package org.com.fr.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommentaireForum {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdCommentaireForum;
	private String ContenueCommentaire;
	private Byte[] fichierCommentaire;
	private Date  DatetimeCommentaire;
	@ManyToOne
	@JoinColumn(name="idForum")
	private Forum forum;
	

	public CommentaireForum() {
		super();
	}
	public CommentaireForum(String contenueCommentaire, Byte[] fichierCommentaire, Date datetimeCommentaire,
			Forum forum) {
		super();
		ContenueCommentaire = contenueCommentaire;
		this.fichierCommentaire = fichierCommentaire;
		DatetimeCommentaire = datetimeCommentaire;
		this.forum = forum;
	}
	public Long getIdCommentaireForum() {
		return IdCommentaireForum;
	}
	public void setIdCommentaireForum(Long idCommentaireForum) {
		IdCommentaireForum = idCommentaireForum;
	}
	public String getContenueCommentaire() {
		return ContenueCommentaire;
	}
	public void setContenueCommentaire(String contenueCommentaire) {
		ContenueCommentaire = contenueCommentaire;
	}
	public Byte[] getFichierCommentaire() {
		return fichierCommentaire;
	}
	public void setFichierCommentaire(Byte[] fichierCommentaire) {
		this.fichierCommentaire = fichierCommentaire;
	}
	public Date getDatetimeCommentaire() {
		return DatetimeCommentaire;
	}
	public void setDatetimeCommentaire(Date datetimeCommentaire) {
		DatetimeCommentaire = datetimeCommentaire;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	
	
	

}
