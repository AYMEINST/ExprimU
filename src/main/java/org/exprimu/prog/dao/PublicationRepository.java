package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.exprimu.prog.entity.Publication;
public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
