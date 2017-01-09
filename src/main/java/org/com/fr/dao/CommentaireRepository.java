package org.com.fr.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.com.fr.entity.Commentaire;
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}
