package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.exprimu.prog.entity.Utilisateur;
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	@Query("SELECT u FROM Utilisateur u WHERE u.email = :email")
	public List<Utilisateur> getUtilisateurByEmail(@Param("email") String email);
}
