package org.com.fr.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Forum implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idForum;
	private Date dateCreationForum;
	private String theme;
	private Boolean statueForum;
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateurForum;
	
	@OneToMany(mappedBy = "forum")
	private List<CommentaireForum> commentairefurum;

	public Long getIdForum() {
		return idForum;
	}

	public void setIdForum(Long idForum) {
		this.idForum = idForum;
	}

	public Date getDateCreationForum() {
		return dateCreationForum;
	}

	public void setDateCreationForum(Date dateCreationForum) {
		this.dateCreationForum = dateCreationForum;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Boolean getStatueForum() {
		return statueForum;
	}

	public void setStatueForum(Boolean statueForum) {
		this.statueForum = statueForum;
	}

	public Utilisateur getUtilisateurForum() {
		return utilisateurForum;
	}

	public void setUtilisateurForum(Utilisateur utilisateurForum) {
		this.utilisateurForum = utilisateurForum;
	}

	public List<CommentaireForum> getCommentairefurum() {
		return commentairefurum;
	}

	public void setCommentairefurum(List<CommentaireForum> commentairefurum) {
		this.commentairefurum = commentairefurum;
	}

	public Forum(Long idForum, Date dateCreationForum, String theme, Boolean statueForum, Utilisateur utilisateurForum,
			List<CommentaireForum> commentairefurum) {
		super();
		this.idForum = idForum;
		this.dateCreationForum = dateCreationForum;
		this.theme = theme;
		this.statueForum = statueForum;
		this.utilisateurForum = utilisateurForum;
		this.commentairefurum = commentairefurum;
	}

	public Forum() {
		super();
	}

}
