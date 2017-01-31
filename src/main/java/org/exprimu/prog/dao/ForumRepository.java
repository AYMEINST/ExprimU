package org.exprimu.prog.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.exprimu.prog.entity.Forum;


public interface ForumRepository extends JpaRepository<Forum, Long> {

	@Query("select f from Forum f where f.idUtilisateur.idUtilisateur = :idUtilisateur")
	public Page<Forum> findMyAll(@Param("idUtilisateur") Long idUtilisateur, Pageable pageable);

	
}
