package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.exprimu.prog.entity.Document;
public interface DocumentRepository extends JpaRepository<Document, Long> {
	@Query("SELECT DC.idFichier FROM Document DC WHERE DC.publication.idPublication = :idPublication ORDER BY DC.idDocument ASC")
	List<Long> ListOfFiles(@Param("idPublication") Long idPublication);
		
}
