//package org.exprimu.prog.web;
//import java.util.List;
//
//import org.exprimu.prog.dao.UtilisateurTempRepository;
//import org.exprimu.prog.entity.UtilisateurTemp;
//import org.exprimu.prog.metier.UtilisateurTempMetier;
//import org.exprimu.prog.metierImp.UtilisateurTempMetierImp;
//import org.jboss.logging.Param;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@RequestMapping(value="/utilisateurt")
//public class UtilisateurTempController {
//	@Autowired
//	private UtilisateurTempMetierImp utilisateurTempMetierImp ;
//	@Autowired
//	private UtilisateurTempRepository UtilisateurTempRepository; 
//
//	
////	@RequestMapping("/index")
////	  void index(HttpServletResponse response) throws IOException {
////	    response.sendRedirect("creationcomptetampon");
////	  }
//	@Secured(value={"ROLE_USER"})
//	@RequestMapping(value="/formut",method=RequestMethod.GET)
//	public String formut(Model model){
//		model.addAttribute("userTemp", new UtilisateurTemp());
//		return "utilisateurt";	
//	}
//	
//	@Secured(value={"ROLE_USER"})
//	@RequestMapping(value="/saveut",method=RequestMethod.POST)
//	public String saveulisateurtemp(UtilisateurTemp ut, Model model){
//		UtilisateurTempRepository.save(ut);
//		model.addAttribute("userTemp", new UtilisateurTemp());		
//		return "utilisateurt";	
//	}
//	
//	@RequestMapping(value="/supputilisateurt",method=RequestMethod.DELETE)
//	public void supputilisateury(@PathVariable(value="id") Long idut){
//		utilisateurTempMetierImp.delete(idut);
//	}
//	
//	
//	@Secured(value={"ROLE_ADMIN"})
//	@RequestMapping(value="/flistutilisateurt")
//	public String formlistutilisateurt(Model model,@RequestParam(name="page",defaultValue="0") int page){
//		Page<UtilisateurTemp> listut= UtilisateurTempRepository.findAll(new PageRequest(page, 10));
//		int countpages = listut.getTotalPages();
//		System.out.println("size :"+listut.getSize());
//		int[] pages = new int[countpages];
//		for(int i=0;i<countpages;i++) pages[i]=i;
//		model.addAttribute("pages",pages);
//		model.addAttribute("listut",listut);
//		return "admin/gestionutilisateurstampon";
//	}
//	
//	@Secured(value={"ROLE_ADMIN"})
//	@RequestMapping(value="/listutilisateurt")
//	public List<UtilisateurTemp> listutilisateur(){
//		return utilisateurTempMetierImp.utilisateurtempList();
//	}
//	
//	
//}
