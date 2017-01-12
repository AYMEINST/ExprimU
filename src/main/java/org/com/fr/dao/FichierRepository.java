package org.com.fr.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.com.fr.entity.Fichier;
public interface FichierRepository extends JpaRepository<Fichier, Long> {
}
