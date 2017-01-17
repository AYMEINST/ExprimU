package org.com.fr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.com.fr.entity.NotePublication;

public interface Note_publicationRepository extends JpaRepository<NotePublication, Long> {
}
