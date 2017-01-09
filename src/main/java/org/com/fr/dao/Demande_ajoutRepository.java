package org.com.fr.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.com.fr.entity.Demande_ajout;
public interface Demande_ajoutRepository extends JpaRepository<Demande_ajout, Long> {
}
