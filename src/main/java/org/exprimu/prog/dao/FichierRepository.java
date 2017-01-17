package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.exprimu.prog.entity.Fichier;
public interface FichierRepository extends JpaRepository<Fichier, Long> {
}
