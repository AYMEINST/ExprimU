package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.exprimu.prog.entity.NotePublication;
public interface NotePublicationRepository extends JpaRepository<NotePublication, Long> {
}
