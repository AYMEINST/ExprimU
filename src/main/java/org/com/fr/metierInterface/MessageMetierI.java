package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Message;
public interface MessageMetierI {
public Page<Message> messagePage(int page, int size);
public List<Message> messageList();
public Message getMessage(Long id);
public Message save(Message message);
public void delete(Long id);
}
