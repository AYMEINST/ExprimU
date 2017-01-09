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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idForum;
	private Byte[] fichier;
	private Date DateCreationForum;
	@OneToMany(mappedBy="forum")
	private List <CommentaireForum> commentairefurum;
	
	
	
	public Forum(Byte[] fichier, Date dateCreationForum, List<CommentaireForum> commentairefurum) {
		super();
		this.fichier = fichier;
		DateCreationForum = dateCreationForum;
		this.commentairefurum = commentairefurum;
	}


	public Forum() {
		super();
	}


	public Long getIdForum() {
		return idForum;
	}


	public void setIdForum(Long idForum) {
		this.idForum = idForum;
	}


	public Byte[] getFichier() {
		return fichier;
	}


	public void setFichier(Byte[] fichier) {
		this.fichier = fichier;
	}


	public Date getDateCreationForum() {
		return DateCreationForum;
	}


	public void setDateCreationForum(Date dateCreationForum) {
		DateCreationForum = dateCreationForum;
	}


	public List<CommentaireForum> getCommentairefurum() {
		return commentairefurum;
	}


	public void setCommentairefurum(List<CommentaireForum> commentairefurum) {
		this.commentairefurum = commentairefurum;
	}
	
	
    


	
	
}
