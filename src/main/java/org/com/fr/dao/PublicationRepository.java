package org.com.fr.dao;

import org.com.fr.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

}
