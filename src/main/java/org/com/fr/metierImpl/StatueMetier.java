package org.com.fr.metierImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.StatueRepository;
import org.com.fr.entity.Statue;
import org.com.fr.metierInterface.StatueMetierI;

@Service
public class StatueMetier implements StatueMetierI {
	@Autowired
	private StatueRepository statueRepository;

	@Override
	public Page<Statue> statuePage(int page, int size) {
		return statueRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public List<Statue> statueList() {
		return statueRepository.findAll();
	}

	@Override
	public Statue getStatue(Long id) {
		return statueRepository.findOne(id);
	}

	@Override
	public Statue save(Statue statue) {
		return statueRepository.save(statue);
	}

	@Override
	public void delete(Long id) {
		statueRepository.delete(statueRepository.findOne(id));
	}
}
