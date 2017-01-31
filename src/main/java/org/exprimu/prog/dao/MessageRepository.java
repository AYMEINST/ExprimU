package org.exprimu.prog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.exprimu.prog.entity.Amis;
import org.exprimu.prog.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
	@Query("SELECT m FROM Message m WHERE m.utilisateurE.idUtilisateur = :idUtilisateur OR m.utilisateurR.idUtilisateur = :idUtilisateur ORDER BY m.date DESC")
	public List<Message> getMessageByUtilisateur(@Param("idUtilisateur") Long idUtilisateur);
}
