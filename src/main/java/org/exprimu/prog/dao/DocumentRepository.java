package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.exprimu.prog.entity.Document;
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
