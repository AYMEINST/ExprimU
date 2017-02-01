package org.exprimu.prog.dao;

import java.util.List;

import org.exprimu.prog.entity.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
	
	@Query("SELECT Cm FROM Commentaire Cm WHERE  Cm.publication.idPublication = :idPublication ORDER BY Cm.idCommentaire ASC")
	public List<Commentaire>ListPublicationCommentaire(@Param("idPublication") Long idPublication);

}
