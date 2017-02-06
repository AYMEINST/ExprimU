package org.exprimu.prog.web;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.exprimu.prog.entity.Fichier;
import org.exprimu.prog.metier.FichierMetier;

@Controller
public class GetFile {
	@Autowired
	private FichierMetier fichierMetier;
	
	@RequestMapping(value = "/index")
	public void index(@RequestParam(name = "id", defaultValue = "0")long id, HttpServletResponse response) throws IOException{
		Fichier f = fichierMetier.findOne(id);
        response.setContentType(f.getMime());
		response.addHeader("Content-Disposition", "attachment; filename=" + f.getName());
		response.setContentLength((int) f.getData().length);

		OutputStream responseOutputStream = response.getOutputStream();
		for(int bytes : f.getData())
			responseOutputStream.write(bytes);
	}

}
