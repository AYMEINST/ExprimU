package org.com.fr.metierImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.PublierRepository;
import org.com.fr.entity.Publier;
import org.com.fr.metierInterface.PublierMetierI;

@Service
public class PublierMetier implements PublierMetierI {
	@Autowired
	private PublierRepository publierRepository;

	@Override
	public Page<Publier> publierPage(int page, int size) {
		return publierRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public List<Publier> publierList() {
		return publierRepository.findAll();
	}

	@Override
	public Publier getPublier(Long id) {
		return publierRepository.findOne(id);
	}

	@Override
	public Publier save(Publier publier) {
		return publierRepository.save(publier);
	}

	@Override
	public void delete(Long id) {
		publierRepository.delete(publierRepository.findOne(id));
	}
}
