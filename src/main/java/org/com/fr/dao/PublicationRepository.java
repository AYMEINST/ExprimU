package org.com.fr.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.com.fr.entity.Publication;
public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
