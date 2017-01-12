package org.com.fr.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.com.fr.entity.Historique;
public interface HistoriqueRepository extends JpaRepository<Historique, Long> {
}
