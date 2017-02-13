package org.exprimu.prog.web;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.RepositoryQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.exprimu.prog.entity.Fichier;
import org.exprimu.prog.metier.FichierMetier;

@Controller
@RequestMapping(value="/Utilisateur")
public class GetFile {
	@Autowired
	private FichierMetier fichierMetier;
	
	@RequestMapping(value = "/index")
	public void showFile(@RequestParam(name = "id", defaultValue = "0")long id, HttpServletResponse response) throws IOException{
		Fichier F = fichierMetier.findOne(id);
        response.setContentType(F.getMime());
		response.addHeader("Content-Disposition", "attachment; filename=" + F.getName());
		response.setContentLength((int) F.getData().length);
		OutputStream responseOutputStream = response.getOutputStream();
		for(int bytes : F.getData())
			responseOutputStream.write(bytes);
	}
}
	