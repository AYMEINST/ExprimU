package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.exprimu.prog.entity.Commentaire;
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}
