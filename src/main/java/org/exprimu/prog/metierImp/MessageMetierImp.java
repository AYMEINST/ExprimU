package org.exprimu.prog.metierImp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.exprimu.prog.entity.Message;
import org.exprimu.prog.entity.Utilisateur;
public interface MessageMetierImp {
public Page<Message> messagePage(int page, int size);
public List<Message> messageList();
public Message getMessage(Long id);
public Message save(Message message);
public void delete(Long id);


}
