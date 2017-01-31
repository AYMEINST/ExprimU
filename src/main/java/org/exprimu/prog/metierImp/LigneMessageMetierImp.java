package org.exprimu.prog.metierImp;

import java.util.List;
import org.springframework.data.domain.Page;
import org.exprimu.prog.entity.LigneMessage;

public interface LigneMessageMetierImp {
	public Page<LigneMessage> ligneMessagePage(int page, int size);

	public List<LigneMessage> ligneMessageList();

	public LigneMessage getLigneMessage(Long id);

	public LigneMessage save(LigneMessage ligneMessage);

	public void delete(Long id);
	
	public List<LigneMessage> ligneMessageByIdMessageList(Long idMessage);
}
