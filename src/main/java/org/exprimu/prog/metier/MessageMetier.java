package org.exprimu.prog.metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.MessageRepository;
import org.exprimu.prog.entity.Message;
import org.exprimu.prog.metierImp.MessageMetierImp;
@Service
public class MessageMetier implements MessageMetierImp{
@Autowired
private MessageRepository messageRepository;
@Override
public Page<Message> messagePage(int page, int size) {
return messageRepository.findAll(new PageRequest(page, size));
}
@Override
public List<Message> messageList() {
return messageRepository.findAll();
}
@Override
public Message getMessage(Long id) {
return messageRepository.findOne(id);
}
@Override
public Message save(Message message) {
return messageRepository.save(message);
}
@Override
public void delete(Long id) {
messageRepository.delete(messageRepository.findOne(id));
}
@Override
public List<Message> getMessageByUtilisateur(Long idUtilisateur) {
	// TODO Auto-generated method stub
	return messageRepository.getMessageByUtilisateur(idUtilisateur);
}
}
