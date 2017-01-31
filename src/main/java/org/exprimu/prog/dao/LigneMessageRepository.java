package org.exprimu.prog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import org.exprimu.prog.entity.LigneMessage;

public interface LigneMessageRepository extends JpaRepository<LigneMessage, Long> {

	@Query("SELECT lm FROM LigneMessage lm WHERE lm.idMessage.idMessage = :idMessage ORDER BY lm.idLigneMessage ASC")
	List<LigneMessage> ligneMessageByIdMessageList(@Param("idMessage") Long idMessage);
//	@Query("SELECT m FROM Message m WHERE m.utilisateurE.idUtilisateur = :idUtilisateur OR m.utilisateurR.idUtilisateur = :idUtilisateur")
//	public List<LigneMessage> getMessageByUtilisateur(@Param("idUtilisateur") Long idUtilisateur);
}
