package org.exprimu.prog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.exprimu.prog.entity.Amis;
import org.exprimu.prog.entity.Utilisateur;

public interface AmisRepository extends JpaRepository<Amis, Long> {
	@Query("SELECT a FROM Amis a WHERE a.utilisateurP.idUtilisateur = :idUtilisateur")
	public List<Amis> getAmisByUtilisateur(@Param("idUtilisateur") Long idUtilisateur);
	
	
	@Query("SELECT a.utilisateurA FROM Amis a WHERE a.utilisateurP.idUtilisateur = :idUtilisateur")
	public List<Utilisateur> getAmisByUtilisateurList(@Param("idUtilisateur") Long idUtilisateur);
	
	
}
