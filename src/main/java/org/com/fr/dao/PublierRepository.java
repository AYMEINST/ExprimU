package org.com.fr.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.com.fr.entity.Publier;
public interface PublierRepository extends JpaRepository<Publier, Long> {
}
