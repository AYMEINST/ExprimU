package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.exprimu.prog.entity.UtilisateurTemp;
public interface UtilisateurTempRepository extends JpaRepository<UtilisateurTemp, Long> {
	
	@Query("select count(u.emailUtilisateurTemp) from UtilisateurTemp u where u.emailUtilisateurTemp like :x")
	public Integer rechecherByMail(@Param("x")String mail);
}
