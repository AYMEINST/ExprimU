package org.exprimu.prog.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.exprimu.prog.entity.UtilisateurTemp;
import org.exprimu.prog.metier.UtilisateurTempMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/utilisateur")
public class UtilisateurTempController {
	@Autowired
	private UtilisateurTempMetier utilisateurTempMetierImp;
	
//	@RequestMapping("/index")
//	  void index(HttpServletResponse response) throws IOException {
//	    response.sendRedirect("creationcomptetampon");
//	  }
	
	@RequestMapping(value="/saveut",method=RequestMethod.POST)
	public UtilisateurTemp saveulisateurtemp(@RequestBody UtilisateurTemp uttmp){
		
		return utilisateurTempMetierImp.save(uttmp);	
	}
	
	@RequestMapping(value="/supputilisateurt",method=RequestMethod.DELETE)
	public void supputilisateury(@PathVariable(value="id") Long idut){
		utilisateurTempMetierImp.delete(idut);
	}
	
	@RequestMapping(value="/listutilisateurt")
	public List<UtilisateurTemp> listutilisateur(){
		return utilisateurTempMetierImp.utilisateurtempList();
	}
}
