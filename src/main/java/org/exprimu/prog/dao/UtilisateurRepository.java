package org.exprimu.prog.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.exprimu.prog.entity.Utilisateur;
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	@Query("SELECT u FROM Utilisateur u WHERE u.email = :email")
	public List<Utilisateur> getUtilisateurByEmail(@Param("email") String email);
	
	@Query("select u from Utilisateur u where u.nom like :x")
	public Page<Utilisateur> listuserByMc(@Param("x")String mc,Pageable page);
	
}
