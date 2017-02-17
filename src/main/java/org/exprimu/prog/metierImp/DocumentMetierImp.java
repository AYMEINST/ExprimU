package org.exprimu.prog.metierImp;

import java.util.List;
import org.springframework.data.domain.Page;
import org.exprimu.prog.entity.Document;

public interface DocumentMetierImp {
	public Page<Document> documentPage(int page, int size);

	public List<Document> documentList();

	public Document getDocument(Long id);

	public Document save(Document document);

	public void delete(Long id);

	public List<Document> getAllDocumentPDFByIdPublication(Long idPublication);

	public List<Document> getAllDocumentPDFByIdUtilisateur(Long idUtilisateur);
	public List<Document> getAllDocumentIMGByIdUtilisateur(Long idUtilisateur);
}
