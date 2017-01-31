package org.exprimu.prog.metierImp;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.exprimu.prog.entity.Message;

public interface MessageMetierImp {
	public Page<Message> messagePage(int page, int size);

	public List<Message> messageList();

	public Message getMessage(Long id);

	public Message save(Message message);

	public void delete(Long id);

	public List<Message> getMessageByUtilisateur(Long idUtilisateur);
}
