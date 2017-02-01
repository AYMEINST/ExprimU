package org.exprimu.prog.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.UtilisateurTempRepository;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.entity.UtilisateurTemp;
import org.exprimu.prog.metierImp.UtilisateurMetierImp;
import org.exprimu.prog.metierImp.UtilisateurTempMetierImp;

@Service
public class UtilisateurTempMetier implements UtilisateurTempMetierImp {
	@Autowired
	private UtilisateurTempRepository utilisateurtempRepository;

	
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	
	@Override
	public Page<UtilisateurTemp> utilisateurtempPage(int page, int size) {
		return utilisateurtempRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public List<UtilisateurTemp> utilisateurtempList() {
		return utilisateurtempRepository.findAll();
	}

	@Override
	public UtilisateurTemp getUtilisateurTemp(Long id) {
		return utilisateurtempRepository.findOne(id);
	}

	@Override
	public UtilisateurTemp save(UtilisateurTemp utilisateurtemp) {
		return utilisateurtempRepository.save(utilisateurtemp);
	}

	@Override
	public void delete(Long id) {
		utilisateurtempRepository.delete(utilisateurtempRepository.findOne(id));
	}
	@Transactional
	@Override
	public void accepteru(Long id) {
		Utilisateur utilisateur = new Utilisateur();
		UtilisateurTemp utp = getUtilisateurTemp(id);
		utilisateur.setNom(utp.getNomUtilisateurTemp());
		utilisateur.setPrenom(utp.getPrenomUtilisateurTemp());
		utilisateur.setEmail(utp.getEmailUtilisateurTemp());
		utilisateur.setPassword(utp.getMotdepasse());
		utilisateur.setStatue_compte(true);
		utilisateurMetier.save(utilisateur);
		delete(id);
	}

	@Override
	public void desactiviercpt(Long id) {
		Utilisateur utilisateur = new Utilisateur();
		UtilisateurTemp utp = getUtilisateurTemp(id);
		utilisateur.setNom(utp.getNomUtilisateurTemp());
		utilisateur.setPrenom(utp.getPrenomUtilisateurTemp());
		utilisateur.setEmail(utp.getEmailUtilisateurTemp());
		utilisateur.setPassword(utp.getMotdepasse());
		utilisateur.setStatue_compte(false);
		utilisateurMetier.save(utilisateur);
		delete(id);
	}

	@Override
	public boolean rechercherbymail(String mail) {
		int numbermail =utilisateurtempRepository.rechecherByMail(mail);
		System.out.println("num de ligne :"+numbermail);
		boolean testmail=true;
		if(numbermail>1){
			testmail=true;
		}
		else if(numbermail == 0){
			testmail=false;
		}
		return testmail;
	}
}
