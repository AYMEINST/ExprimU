package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.exprimu.prog.entity.Document;
public interface DocumentRepository extends JpaRepository<Document, Long> {
	@Query("SELECT DC.idFichier FROM Document DC WHERE DC.publication.idPublication = :idPublication ORDER BY DC.idDocument ASC")
	List<Long> ListOfFiles(@Param("idPublication") Long idPublication);
	
	// SELECT id_document, date_creation, description_fichier, id_fichier, id_publication FROM document WHERE id_fichier IN (SELECT id_fichier FROM fichier WHERE mime = "application/pdf" ) AND id_publication = 8
		@Query("SELECT d FROM Document d WHERE d.idFichier IN (SELECT f.idFichier FROM Fichier f WHERE f.mime = 'application/pdf') AND d.publication.idPublication = :id")
		public List<Document> getAllDocumentPDFByIdPublication(@Param("id") Long id);

		@Query("SELECT d FROM Document d WHERE d.idFichier IN (SELECT f.idFichier FROM Fichier f WHERE f.mime = 'application/pdf') AND d.publication.utilisateur.idUtilisateur = :id")
		public List<Document> getAllDocumentPDFByIdUtilisateur(@Param("id") Long id);
		
		@Query("SELECT d FROM Document d WHERE d.idFichier IN (SELECT f.idFichier FROM Fichier f WHERE f.mime = 'image/*') AND d.publication.utilisateur.idUtilisateur = :id")
		public List<Document> getAllDocumentIMGByIdUtilisateur(@Param("id") Long id);
		
}
