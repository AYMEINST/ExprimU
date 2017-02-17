package org.exprimu.prog.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exprimu.prog.metier.DocumentMetier;
import org.exprimu.prog.metier.FichierMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.exprimu.prog.entity.Document;
import org.exprimu.prog.entity.Forum;
import org.exprimu.prog.entity.ForumCommentaire;
import org.exprimu.prog.entity.Publication;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metier.ForumCommentaireMetier;
import org.exprimu.prog.metier.ForumMetier;
import org.exprimu.prog.metier.UtilisateurMetier;

@Controller
@RequestMapping(value = "/PdfJson")
public class PdfJsonController {

	@Autowired
	private DocumentMetier documentMetier;

	@Autowired
	private UtilisateurMetier utilisateurMetier;

	@ResponseBody
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Show")
	public Map<String, Object> GetMap(@RequestParam(name = "id", defaultValue = "0") long id) {
		Map<String, Object> x = new HashMap<String, Object>(4);
		if (id != 0) {
			Document document = documentMetier.getDocument(id);
			Utilisateur utilisateur = document.getPublication().getUtilisateur();
			Publication publication = document.getPublication();

			List<Document> ds = documentMetier.getAllDocumentPDFByIdUtilisateur(utilisateur.getIdUtilisateur());
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
