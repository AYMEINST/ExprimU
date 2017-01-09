package org.com.fr.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.com.fr.entity.Contenu;
public interface ContenuRepository extends JpaRepository<Contenu, Long> {
}
