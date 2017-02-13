
package org.exprimu.prog.web;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;

import org.exprimu.prog.entity.Document;
import org.exprimu.prog.entity.Fichier;
import org.exprimu.prog.entity.Publication;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metier.DocumentMetier;
import org.exprimu.prog.metier.FichierMetier;
import org.exprimu.prog.metier.PublicationMetier;
import org.exprimu.prog.metierImp.PublicationMetierImp;
import org.exprimu.prog.metierImp.UtilisateurMetierImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/Profil")
//@MultipartConfig(fileSizeThreshold = 20971520)
public class PublicationController {

	@Autowired
	private PublicationMetierImp publicationMetierI;
	@Autowired
	private PublicationMetier PublicationMetier;
	@Autowired
	private UtilisateurMetierImp UtilisateurMetier;
	@Autowired
	private FichierMetier fichierMetier;
	@Autowired
	private DocumentMetier DocumentMetier;

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Publication> publicationList() {
		return publicationMetierI.publicationList();
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Publication getPublication(@PathVariable Long id) {
		return publicationMetierI.getPublication(id);
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/SaveStatue", method = RequestMethod.POST)
	public Publication save(@RequestBody Publication publication) {
		publication.setUtilisateur((Utilisateur) UtilisateurMetier.getConnectedUser().get("utilisateur"));
		return publicationMetierI.save(publication);
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		publicationMetierI.delete(id);
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Update", method = RequestMethod.PUT)
	public void updatePublication(@RequestParam Long idPublication, @RequestParam String statue,
			@RequestParam String tritrePublication, @RequestParam String DescriptifDocument,
			@RequestParam Long idFichier) {
		publicationMetierI.updatePublication(idPublication, statue, tritrePublication, DescriptifDocument, idFichier);
	}

	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Save", method = RequestMethod.POST)
	public void savePublication(@RequestParam String statue, @RequestParam String tritrePublication, @RequestParam("files") MultipartFile[] files) {
		
		System.out.println("Statue :" + statue);
		System.out.println("TritrePublication :" + tritrePublication);
		Publication publication = new Publication();
		publication.setDatePublication(new Date());
		publication.setStatuePublication(statue);
		publication.setTitrePublication(tritrePublication);
		publication.setUtilisateur((Utilisateur) UtilisateurMetier.getConnectedUser().get("utilisateur"));
		Publication P = PublicationMetier.save(publication);
		
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				// file.getBytes();
				System.out.println(file.getName());
				System.out.println(file.getSize());
				System.out.println(file.getContentType());
				
				try {
					Document document = new Document();
					Fichier fichier = new Fichier(file.getName(), file.getContentType(), file.getSize(), file.getBytes());
					Long idFichier= fichierMetier.save(fichier).getIdFichier();
					document.setDateCreation(new Date());
					document.setIdFichier(idFichier);
					document.setPublication(P);
					DocumentMetier.save(document);
//					publication.getListdocument().add(D);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

	}	
	
	@RequestMapping(value = "/download/{id}" ,method= RequestMethod.GET)
	public void showFile( @RequestParam(name = "id", defaultValue = "0")long id, HttpServletResponse response) throws IOException{
		List<Fichier> AllFilles =fichierMetier.findAll();
		for (Fichier F : AllFilles) {
	        response.setContentType(F.getMime());
			response.addHeader("Content-Disposition", "attachment; filename=" + F.getName());
			response.setContentLength((int) F.getData().length);
			OutputStream responseOutputStream = response.getOutputStream();
			for(int bytes : F.getData())
				responseOutputStream.write(bytes);
		}
		
		
	}


}