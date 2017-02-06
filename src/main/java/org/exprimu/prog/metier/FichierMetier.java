package org.exprimu.prog.metier;
import java.util.List;

import org.exprimu.prog.dao.FichierRepository;
import org.exprimu.prog.entity.Fichier;
import org.exprimu.prog.metierImp.FichierMetierImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class FichierMetier implements FichierMetierImp {
	@Autowired
	private FichierRepository fichierRepository;

	@Override
	public Fichier findOne(Long arg0) {
		// TODO Auto-generated method stub
		return fichierRepository.findOne(arg0);
	}

	@Override
	public Page<Fichier> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return fichierRepository.findAll(arg0);
	}

	@Override
	public List<Fichier> findAll() {
		
		// TODO Auto-generated method stub
		return fichierRepository.findAll();
	}

	@Override
	public Fichier save(Fichier u) {
		// TODO Auto-generated method stub
		return fichierRepository.save(u);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		fichierRepository.delete(id);

	}

}