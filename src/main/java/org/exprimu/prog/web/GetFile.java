package org.exprimu.prog.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.exprimu.prog.entity.Fichier;
import org.exprimu.prog.metier.FichierMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GetFile {
	@Autowired
	private FichierMetier fichierMetier;
	
	@RequestMapping(value = "/index")
	public void index(@RequestParam(name = "id", defaultValue = "0")long id, HttpServletResponse response) throws IOException{
		Fichier f = fichierMetier.findOne(id);
		System.out.println(f.getMime());
		System.out.println(f.getName());
		System.out.println(f.getSize());
		System.out.println(f.getData().length);
        response.setContentType(f.getMime());
		//response.addHeader("Content-Disposition", "attachment; filename=" + f.getName() + ".pdf");
		response.setContentLength((int) f.getData().length);
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		OutputStream responseOutputStream = response.getOutputStream();
		//for(int bytes : f.getData()){
			responseOutputStream.write(f.getData());
		//}
	}

}

