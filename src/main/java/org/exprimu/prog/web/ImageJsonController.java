package org.exprimu.prog.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exprimu.prog.entity.Document;
import org.exprimu.prog.entity.Publication;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metier.DocumentMetier;
import org.exprimu.prog.metier.UtilisateurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageJsonController {
	@Autowired
	private DocumentMetier documentMetier;

	@Autowired
	private UtilisateurMetier utilisateurMetier;
	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Show")
	public Map<String, Object> GetMap(@RequestParam(name = "id", defaultValue = "0") long id) {
		Map<String, Object> x = new HashMap<String, Object>(4);
		if (id != 0) {
			Document document = documentMetier.getDocument(id);
			Utilisateur utilisateur = document.getPublication().getUtilisateur();
			Publication publication = document.getPublication();

			List<Document> ds = documentMetier.getAllDocumentIMGByIdUtilisateur(utilisateur.getIdUtilisateur());
			List<Map<String, Object>> dsm = new ArrayList<Map<String, Object>>();
			
			for (Document d : ds) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("document", d);
				m.put("publication", d.getPublication());
				dsm.add(m);
			}
			
			x.put("document", document);
			x.put("publication", publication);
			x.put("autreDocument", dsm);
			x.put("user", utilisateur);
		}
		return x;
	}

}
