package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.exprimu.prog.entity.Utilisateur;
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
