package org.exprimu.prog.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.exprimu.prog.entity.UtilisateurTemp;
public interface UtilisateurTempRepository extends JpaRepository<UtilisateurTemp, Long> {
	@Query("select count(u.emailUtilisateurTemp) from UtilisateurTemp u where u.emailUtilisateurTemp like :x")
	public Integer rechecherByMail(@Param("x")String mail);
	
	@Query("select u from UtilisateurTemp u where u.nomUtilisateurTemp like :y")
	public Page<UtilisateurTemp> rechecherut(@Param("y")String mc,Pageable page);
}
