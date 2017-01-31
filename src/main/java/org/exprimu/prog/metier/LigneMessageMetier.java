package org.exprimu.prog.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.LigneMessageRepository;
import org.exprimu.prog.entity.LigneMessage;
import org.exprimu.prog.metierImp.LigneMessageMetierImp;

@Service
public class LigneMessageMetier implements LigneMessageMetierImp {
	@Autowired
	private LigneMessageRepository ligneMessageRepository;

	@Override
	public Page<LigneMessage> ligneMessagePage(int page, int size) {
		// TODO Auto-generated method stub
		return ligneMessageRepository.findAll(new PageRequest(page, size));
	}

	@Override
	public List<LigneMessage> ligneMessageList() {
		// TODO Auto-generated method stub
		return ligneMessageRepository.findAll();
	}

	@Override
	public LigneMessage getLigneMessage(Long id) {
		// TODO Auto-generated method stub
		return ligneMessageRepository.findOne(id);
	}

	@Override
	public LigneMessage save(LigneMessage ligneMessage) {
		// TODO Auto-generated method stub
		return ligneMessageRepository.save(ligneMessage);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ligneMessageRepository.delete(ligneMessageRepository.findOne(id));
	}

	@Override
	public List<LigneMessage> ligneMessageByIdMessageList(Long idMessage) {
		// TODO Auto-generated method stub
		return ligneMessageRepository.ligneMessageByIdMessageList(idMessage);
	}

	
}
